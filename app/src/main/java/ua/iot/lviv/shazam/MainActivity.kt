package ua.iot.lviv.shazam

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.iot.lviv.client.api.MoviecontrollerApi
import ua.iot.lviv.client.model.Recorded
import ua.iot.lviv.shazam.service.DatabaseService

import java.io.File
import java.io.IOException

private const val LOG_TAG = "AudioRecordTest"
private const val REQUEST_RECORD_AUDIO_PERMISSION = 200

class MainActivity : AppCompatActivity() {
    val client = MoviecontrollerApi()
    private var recordingStatus = true
    private var playbackStatus = true
    private var recorder: MediaRecorder? = null
    private lateinit var fileName: String
    var recorded: Recorded? = null
    private var permissionToRecordAccepted = false
    private var callTime = 0
    private var movieId = 0
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_white_arrow)
        progressRecBar.visibility = View.GONE
        val databaseService = DatabaseService(this)
        fileName = "${externalCacheDir?.absolutePath}/audiorecordtest.3gp"
        var downloadedMoviePath = "${externalCacheDir?.absolutePath}/"
        val recordingFile = File(fileName)
        var downloadStatus = false

        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                recognizeButton.setOnClickListener {
                    onRecord(recordingStatus)
                    recognizeButton.text = when (recordingStatus) {
                        true -> "Stop recognition"
                        false -> "Start recognition"
                    }
                    recordingStatus = !recordingStatus
                    if (recognizeButton.text == "Start recognition") {

                        progressRecBar.visibility = View.VISIBLE
                        GlobalScope.launch(Dispatchers.IO) {
                            val startTime = System.nanoTime()
                            recorded = client.recognizeMovieUsingPOST(recordingFile)

                            val movieList = client.soundsUsingGET
                            val endTime = System.nanoTime()
                            callTime += ((endTime - startTime) / 1000000).toInt()

                            withContext(Dispatchers.Main) {
                                if (recorded!!.recognized) {

                                    for (movie in movieList) {
                                        if (movie.movieName == recorded?.movieName) {
                                            movieId = movie.id
                                            break
                                        }
                                    }
                                    var audioBytes: ByteArray? = null


                                    GlobalScope.launch(Dispatchers.IO) {
                                        val downloadedMovie =
                                            databaseService.getMovieByTitle(recorded?.movieName!!)

                                        if (downloadedMovie == null) {
                                            downloadedMoviePath += recorded?.movieName + ".mp3"
                                            val tempDownloadedMovie = File(downloadedMoviePath)
                                            if (!tempDownloadedMovie.exists()) {
                                                val startTime = System.nanoTime()
                                                audioBytes =
                                                    client.getAudiofileByIdUsingGET(movieId)
                                                tempDownloadedMovie.writeBytes(audioBytes!!)
                                                val endTime = System.nanoTime()
                                                callTime += ((endTime - startTime) / 1000000).toInt()
                                            }
                                        } else {

                                            downloadedMoviePath = File(
                                                this@MainActivity.cacheDir,
                                                "${recorded?.movieName!!}.mp3"
                                            ).absolutePath
                                            downloadStatus = true
                                        }

                                        withContext(Dispatchers.Main) {
                                            val bundle = Bundle()
                                            bundle.putString("file_name", downloadedMoviePath)
                                            bundle.putString("movie_title", recorded?.movieName)
                                            bundle.putInt(
                                                "time",
                                                recorded?.time!!.toInt() + callTime
                                            )
                                            bundle.putInt("id", movieId)
                                            bundle.putBoolean("downloadStatus", downloadStatus)

                                            val intent1 =
                                                Intent(
                                                    this@MainActivity,
                                                    PlaybackActivity::class.java
                                                )
                                            intent1.putExtra("recognition_data", bundle)
                                            progressRecBar.visibility = View.GONE
                                            startActivity(intent1)
                                        }
                                    }


                                } else {
                                    progressRecBar.visibility = View.GONE
                                    errorText.text =
                                        "Could not recognize the recording, please try again."
                                }
                                playbackStatus = !playbackStatus
                            }
                        }
                    }
                }
            }
        }


    }

    private fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }

            start()
        }
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
    }

    private fun onRecord(start: Boolean) = if (start) {

        startRecording()
    } else {
        stopRecording()
    }

    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        menu.findItem(R.id.action_search).isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }
}
