package ua.iot.lviv.shazam.service

import android.content.Context
import androidx.room.Room
import ua.iot.lviv.shazam.database.DatabaseApp
import ua.iot.lviv.shazam.database.model.Movie

class DatabaseService(appContext: Context) {
   private val db: DatabaseApp = Room.databaseBuilder(
        appContext.applicationContext,
        DatabaseApp::class.java, "movie.db"
    ).build()

    fun deleteMovieByTitle(title: String) {
        db.movieDao().delete(db.movieDao().findByTitle(title))
    }

    fun getMovieByTitle(title: String): Movie {
        return db.movieDao().findByTitle(title)
    }

    fun insertMovie(movie: Movie) {
        db.movieDao().insertAll(movie)
    }

    fun getAllMovies(): List<Movie>{
        return db.movieDao().getAll()
    }
}