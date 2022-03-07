package com.example.kotlintest.MoudlePage.Datapase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlintest.MoudlePage.DOA.itemDoa
import com.example.kotlintest.MoudlePage.itemdata

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(itemdata::class), version = 1, exportSchema = false)
public abstract class RoomConnet(): RoomDatabase() {
    abstract fun ItemDoa():itemDoa
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RoomConnet? = null

        fun getDatabase(context: Context): RoomConnet {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomConnet::class.java,
                    "itemdata"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
