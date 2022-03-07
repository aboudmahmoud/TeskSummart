package com.example.kotlintest.MoudlePage

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class itemdata(
    //here to hold data in action item
    @ColumnInfo(name="TitleColumn")
    val Title:String,
    //hero for is check item
    //its false cause item its not checked by defult
    @ColumnInfo(name="StatusColumn")
    val IsChecked:Boolean=false,
)

