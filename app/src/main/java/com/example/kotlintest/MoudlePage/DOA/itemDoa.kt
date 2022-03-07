package com.example.kotlintest.MoudlePage.DOA

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlintest.MoudlePage.itemdata

@Dao
interface itemDoa {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun  insetdata(ItemData:itemdata)

      @Query("select * from itemdata")
   fun getAllItems(): MutableList<itemdata>
}