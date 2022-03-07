package com.example.kotlintest.MoudlePage.respoty

import android.app.Application
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlintest.MoudlePage.DOA.itemDoa
import com.example.kotlintest.MoudlePage.Datapase.RoomConnet
import com.example.kotlintest.MoudlePage.itemdata

class Reposty(val ItemDao:itemDoa) {




    fun  insetdata(ItemData: itemdata) {}


    fun getAllItems(): MutableList<itemdata> = ItemDao.getAllItems()
}