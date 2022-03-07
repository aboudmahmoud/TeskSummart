package com.example.kotlintest


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintest.Adpatpter.adpaterPage
import com.example.kotlintest.ItemApcliction.itemApclction
import com.example.kotlintest.MoudlePage.ViewModel.ItemViewModel
import com.example.kotlintest.MoudlePage.ViewModel.ItemViewModelFactory
import com.example.kotlintest.MoudlePage.itemdata
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
private lateinit var itewmAdpater:adpaterPage

//Room Datapase doesnt Work
    /*private val ViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as itemApclction).repository)
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count=intent.getIntExtra("Count",0)
        var mod=intent.getBooleanExtra("mod",true);






        var mutableList1 = mutableListOf(itemdata("Fist item ",false),itemdata("Scend item",false),itemdata("thrid item",false),itemdata("Fourth item",false),itemdata("fifth item",false))



        itewmAdpater= adpaterPage(mutableList1,this,count,mod)

        RVItems.adapter=itewmAdpater
        RVItems.layoutManager=LinearLayoutManager(this)

    }
}