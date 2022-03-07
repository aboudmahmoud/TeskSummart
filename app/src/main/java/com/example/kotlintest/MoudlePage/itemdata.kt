package com.example.kotlintest.MoudlePage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="itemdata")
class itemdata(
    //here to hold data in action item
    @PrimaryKey
    @ColumnInfo(name = "Title")
    val Title:String,
    //hero for is check item
    //its false cause item its not checked by defult

    val IsChecked:Boolean=false,
)

