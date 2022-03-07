package com.example.kotlintest.MoudlePage.respoty

import androidx.annotation.WorkerThread
import com.example.kotlintest.MoudlePage.DOA.itemDoa
import com.example.kotlintest.MoudlePage.itemdata

class Reposty( val ItemDao:itemDoa) {

    val  getAllItems:MutableList<itemdata> = ItemDao.getAllItems()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun  insetdata(ItemData: itemdata) {}



}