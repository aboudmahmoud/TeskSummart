package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintest.Adpatpter.adpaterPage
import com.example.kotlintest.ItemApcliction.itemApclction
import com.example.kotlintest.MoudlePage.ViewModel.ItemViewModel
import com.example.kotlintest.MoudlePage.ViewModel.WordViewModelFactory
import com.example.kotlintest.MoudlePage.itemdata
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var itewmAdpater:adpaterPage



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count=intent.getIntExtra("Count",0)
        var mod=intent.getBooleanExtra("mod",true);
      //  itemviewmoel.insert(itemdata("frist item",false))
        var mutableList1 = mutableListOf(itemdata("Frist item",false),itemdata("Scend item",false),itemdata("thrid item",false),itemdata("Fourth item",false),itemdata("fifth item",false))
        //var mutableList2= itemviewmoel.getAllItems
        itewmAdpater= adpaterPage(mutableList1,this,count,mod)

        RVItems.adapter=itewmAdpater
        RVItems.layoutManager=LinearLayoutManager(this)

    }
}