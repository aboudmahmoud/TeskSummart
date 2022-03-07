package com.example.kotlintest.ItemApcliction


import android.app.Application
import com.example.kotlintest.MoudlePage.Datapase.ItemDatabase
import com.example.kotlintest.MoudlePage.respoty.Reposty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class itemApclction: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {ItemDatabase.getDatabase(this,applicationScope)}
    val repository by lazy {Reposty(database.ItemDoa())}
}