package com.example.kotlintest.MoudlePage.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlintest.MoudlePage.Datapase.ItemDatabase
import com.example.kotlintest.MoudlePage.itemdata
import com.example.kotlintest.MoudlePage.respoty.Reposty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel (private val repository:Reposty) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val readAllData: MutableList<itemdata> =repository.getAllItems

    private lateinit var reposty:Reposty

    fun insert(item: itemdata) = viewModelScope.launch {
        repository.insetdata(item)
    }
    }
class ItemViewModelFactory(private val repository: Reposty) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



