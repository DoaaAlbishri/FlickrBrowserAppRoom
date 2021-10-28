package com.example.flickrbrowserapproom

import android.provider.ContactsContract
import androidx.room.*

@Dao
interface ImageDao {

    @Query("SELECT * FROM FavImage")
    fun getImage(): List<Image>

    @Insert
    fun insertImage(image: Image)

    @Delete
    fun deleteImage(image: Image)

    @Update
    fun updateNote(image: Image)

}