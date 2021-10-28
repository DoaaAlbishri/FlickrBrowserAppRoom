package com.example.flickrbrowserapproom

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Image::class],version = 1,exportSchema = false)
abstract class ImageDatabase:RoomDatabase() {

    companion object{
        var instance:ImageDatabase?=null;
        fun getInstance(ctx: Context):ImageDatabase
        {
            if(instance!=null)
            {
                return  instance as ImageDatabase;
            }
            instance= Room.databaseBuilder(ctx,ImageDatabase::class.java,"details").run { allowMainThreadQueries() }.build();
            return instance as ImageDatabase;
        }
    }
    abstract fun ImageDao():ImageDao;
}