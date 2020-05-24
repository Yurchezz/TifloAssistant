package ua.iot.lviv.shazam.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ua.iot.lviv.shazam.database.model.Movie

@Dao
interface MovieDao {
    @Query("select * from movie")
    fun getAll(): List<Movie>

    @Query("select * from movie where title = (:title)")
    fun findByTitle(title: String): Movie

    @Delete
    fun delete(movie: Movie)

    @Insert
    fun insertAll(vararg movies: Movie)
}