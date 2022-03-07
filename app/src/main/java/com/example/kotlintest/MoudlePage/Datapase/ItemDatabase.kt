package com.example.kotlintest.MoudlePage.Datapase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kotlintest.MoudlePage.DOA.itemDoa
import com.example.kotlintest.MoudlePage.itemdata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(itemdata::class), version = 1, exportSchema = false)
public abstract class ItemDatabase(): RoomDatabase() {
    abstract fun ItemDoa():itemDoa
    private class ItemDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var ItemDao = database.ItemDoa()



                    // Add sample words.
                    var item = itemdata("item zero",false)
                    ItemDao.insetdata(item)

                }
            }
        }
    }
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope): ItemDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
           return INSTANCE?:synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "itemdata"
                ) .addCallback(ItemDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }

}
