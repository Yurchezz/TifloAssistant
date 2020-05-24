package ua.iot.lviv.shazam

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_playback.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.iot.lviv.client.api.MoviecontrollerApi
import java.io.File
import java.io.IOException

private const val LOG_TAG = "AudioRecordTest"

class PlaybackActivity : AppCompatActivity() {
    val client = MoviecontrollerApi()
    private var player: MediaPlayer? = null
    private var playbackStatus = true
    private var fileName: String? = null
    private var time: Int = 0
    private var id = 0
    private var photoBytes: ByteArray? = null
    private var downloadStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val startTime = System.nanoTime()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playback)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_white_arrow)
        val recognitionData = intent.getBundleExtra("recognition_data")
        fileName = recognitionData!!.getString("file_name")
        val movieTitle = recognitionData.getString("movie_title")
        time += recognitionData.getInt("time")
        movieTitleText.text = movieTitle
        id = recognitionData.getInt("id")
        downloadStatus = recognitionData.getBoolean("downloadStatus")
        val endTime = System.nanoTime()
        time += ((endTime - startTime) / 1000000).toInt() + 300

        GlobalScope.launch(Dispatchers.IO) {
            val startTime1 = System.nanoTime()

            photoBytes = if (!downloadStatus) {
                client.getForegroundPhotoByIdUsingGET(id)
            } else {
                val photoFile = File(this@PlaybackActivity.cacheDir, "${movieTitle}.jpg")
                photoFile.readBytes()
            }
            val photo = BitmapFactory.decodeByteArray(photoBytes, 0, photoBytes!!.size)
            val endTime1 = System.nanoTime()
            time += ((endTime1 - startTime1) / 1000000).toInt()

            withContext(Dispatchers.Main) {
                moviePoster.setImageResource(android.R.color.transparent)
                moviePoster.setImageBitmap(photo)
                onPlay(playbackStatus)
                stopPlayButton.setOnClickListener {
                    playbackStatus = !playbackStatus
                    onPlay(playbackStatus)
                    val intent1 = Intent(this@PlaybackActivity, MainActivity::class.java)
                    startActivity(intent1)
//                    super.onBackPressed()
                }
            }
        }


    }

    private fun startPlaying() {
        player = MediaPlayer().apply {
            try {
                setDataSource(fileName)
                prepare()
                seekTo(time)
                start()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
        }
    }

    private fun stopPlaying() {
        player?.release()
        player = null
    }

    private fun onPlay(start: Boolean) = if (start) {
        startPlaying()
    } else {
        stopPlaying()
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        menu.findItem(R.id.action_search).isVisible = false
        return true
    }

}
