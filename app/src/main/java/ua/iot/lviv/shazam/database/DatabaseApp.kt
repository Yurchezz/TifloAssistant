package ua.iot.lviv.shazam.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.iot.lviv.shazam.database.dao.MovieDao
import ua.iot.lviv.shazam.database.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}