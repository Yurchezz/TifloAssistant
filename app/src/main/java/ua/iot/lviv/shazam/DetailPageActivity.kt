package ua.iot.lviv.shazam

import android.app.ActionBar
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.*
import ua.iot.lviv.client.api.MoviecontrollerApi
import ua.iot.lviv.shazam.database.model.Movie
import ua.iot.lviv.shazam.service.DatabaseService
import java.io.File


class DetailPageActivity : AppCompatActivity() {
    val client = MoviecontrollerApi()
    var downloadStatus = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_white_arrow)
        progressBar3.visibility = View.GONE

        val actionBar = supportActionBar
        val downloadButton: Button
        downloadButton = findViewById(R.id.button_id)
        val databaseService = DatabaseService(this)

        //get data from previous activity when item of listview is clicked using intent
        val intent = intent
        val mActionBarTitle = intent.getStringExtra("actionBarTitle")
        val mContent = intent.getStringExtra("contentTv")
        val id = intent.getIntExtra("id", 0)
        val internetConnectionStatus = intent.getBooleanExtra("internetConnectionStatus", false)
//        film_image.setImageBitmap(BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size))
        GlobalScope.launch(Dispatchers.IO) {
            val photoBytes = if (internetConnectionStatus) {
            client.getForegroundPhotoByIdUsingGET(id)
        } else {
                File(
                    this@DetailPageActivity.cacheDir,
                    "${mActionBarTitle}.jpg"
                ).readBytes()
            }
            val photo = BitmapFactory.decodeByteArray(photoBytes, 0, photoBytes!!.size)
            val downloadedMovie = databaseService.getMovieByTitle(mActionBarTitle)
            if (downloadedMovie != null) {
                downloadStatus = true
            }
            withContext(Dispatchers.Main) {
                film_image.setImageResource(android.R.color.transparent)
                film_image.setImageBitmap(photo)
                actionBar!!.title = mActionBarTitle
                film_lable.text = mActionBarTitle
                filmDescription.text = mContent
                if (downloadStatus) {
                    downloadButton.text = "Synchronize"

                }
                downloadButton.setOnClickListener {
                    if (!downloadStatus) {
                        GlobalScope.launch(Dispatchers.Main) {
                            progressBar3.visibility = View.VISIBLE
                            progressBar3.setProgress(20)
                            delay(1000)
                            progressBar3.setProgress(33)
                            delay(110)
                            progressBar3.setProgress(40)
                            delay(1300)
                            progressBar3.setProgress(45)
                            delay(2000)
                            progressBar3.setProgress(60)
                            delay(1000)
                            progressBar3.setProgress(65)
                            delay(1000)
                            progressBar3.setProgress(75)
                            delay(1000)
                            progressBar3.setProgress(90)
                            delay(500)
                            progressBar3.setProgress(100)
                            delay(1000)

                            withContext(Dispatchers.IO) {
                               val audioBytes = client.getAudiofileByIdUsingGET(id)

                                val audioFile = File(this@DetailPageActivity.cacheDir, "${mActionBarTitle}.mp3")
                                val photoFile = File(this@DetailPageActivity.cacheDir, "${mActionBarTitle}.jpg")
                                audioFile.writeBytes(audioBytes)
                                photoFile.writeBytes(photoBytes)
                                databaseService.insertMovie(Movie(id, mActionBarTitle, mContent, true))
                            }
                            progressBar3.visibility = View.GONE

                            val mAlertDialog = AlertDialog.Builder(
                                this@DetailPageActivity,
                                AlertDialog.THEME_DEVICE_DEFAULT_DARK
                            )
                            mAlertDialog.setIcon(R.drawable.green)
                            mAlertDialog.setTitle("Success")
                            mAlertDialog.setMessage("Film downloaded successfully")

                            mAlertDialog.setPositiveButton("Ok") { dialog, id ->

                                Toast.makeText(
                                    this@DetailPageActivity,
                                    "Enjoy the film",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            mAlertDialog.setNegativeButton("sync") { dialog, id ->
                                val intent1 = Intent(this@DetailPageActivity, MainActivity::class.java)
                                startActivity(intent1)
                            }

//                            mAlertDialog.setPositiveButton(
//                                "Yes"
//                            ) { dialog, id -> dialog.cancel() }
//
//                            mAlertDialog.setNegativeButton(
//                                "No"
//                            ) { dialog, id -> dialog.cancel() }
                            downloadStatus = true
                            downloadButton.text = "Synchronize"
                            mAlertDialog.show()
                        }
                    } else {
                        startActivity(Intent(this@DetailPageActivity, MainActivity::class.java))
                    }


                }
            }

        }

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