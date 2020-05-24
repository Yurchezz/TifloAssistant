package ua.iot.lviv.shazam

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.iot.lviv.client.api.MoviecontrollerApi
import ua.iot.lviv.client.model.SoundBoard
import ua.iot.lviv.shazam.service.DatabaseService
import ua.iot.lviv.shazam.service.InternetChecker
import java.util.*


class HomePageActivity : AppCompatActivity() {

    val client = MoviecontrollerApi()
    var movieList: List<SoundBoard>? = null
    internal lateinit var listView: ListView
    internal lateinit var adapter: ListViewAdapter
    lateinit var icon: IntArray
    var arrayList = ArrayList<SoundBoard>()
    val arrayOfTitles = mutableListOf<String>()
    val arrayOfDescriptions = mutableListOf<String>()
    var internetConnectionStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var title: Array<String>
        var description: Array<String>
        var photoBytes: ByteArray

        val databaseService = DatabaseService(this)


        searchImageButton.setOnClickListener {
            val intent1 = Intent(this@HomePageActivity, MainActivity::class.java)
            startActivity(intent1)
        }

        GlobalScope.launch(Dispatchers.IO) {
            internetConnectionStatus = InternetChecker.isInternetAvaliable()
            if (internetConnectionStatus) {
                val movies = client.soundsUsingGET
                val imageViewArray = Array(movies.size) { 0 }
                for (movie in movies) {
                    arrayList.add(movie)
                }
            } else {
                val moviesFromDatabase = databaseService.getAllMovies()
                moviesFromDatabase.forEach { movie ->
                    val soundBoard = SoundBoard()
                    soundBoard.movieName = movie.title
                    soundBoard.description = movie.description
                    soundBoard.id = movie.uid
                    arrayList.add(soundBoard)
                }
            }

            withContext(Dispatchers.Main) {


                icon = intArrayOf(
                    R.drawable.battery,
                    R.drawable.cpu,
                    R.drawable.display,
                    R.drawable.memory,
                    R.drawable.sensor
                )


                if (internetConnectionStatus) {
                    supportActionBar?.title = "                      Avaliable movies"
                } else {
                    supportActionBar?.title = "         Offline movies"
                }


                listView = findViewById(R.id.listView)
                //pass results to listViewAdapter class
                adapter =
                    ListViewAdapter(this@HomePageActivity, arrayList, internetConnectionStatus)

                //bind the adapter to the listview
                listView.adapter = adapter
            }
        }

        /*                   title = arrayOf("Battery", "Cpu", "Display", "Memory", "Sensor")
                       description = arrayOf(
                           "Battery detail...",
                           "Cpu detail...",
                           "Display detail...",
                           "Memory detail...",
                           "Sensor detail..."
                       )*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        menu.findItem(R.id.connection_button).isVisible = !internetConnectionStatus
        val myActionMenuItem = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(myActionMenuItem) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("")
                    listView.clearTextFilter()
                } else {
                    adapter.filter(s)
                }
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.connection_button) {
            GlobalScope.launch(Dispatchers.IO) {
                val immediateInternetCheck = InternetChecker.isInternetAvaliable()

                withContext(Dispatchers.Main) {
                    if (immediateInternetCheck) {
                        val homeIntent = intent
                        finish()
                        startActivity(homeIntent)
                    } else {
                        Toast.makeText(
                            this@HomePageActivity,
                            "Couldn't connect to the server, please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            true
        } else super.onOptionsItemSelected(item)
    }

}