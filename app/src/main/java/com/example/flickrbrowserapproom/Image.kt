package com.example.flickrbrowserapproom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "FavImage")
data class Image(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val ID: Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "link")
    var link: String)
