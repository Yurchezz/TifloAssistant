package ua.iot.lviv.shazam.database.model

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "download_status") var downloadStatus: Boolean

    )
