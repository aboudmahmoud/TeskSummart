package com.example.kotlintest.MoudlePage.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlintest.MoudlePage.itemdata
import com.example.kotlintest.MoudlePage.respoty.Reposty
import kotlinx.coroutines.launch

class ItemViewModel (private val repository: Reposty) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val getAllItems: MutableList<itemdata> = repository.getAllItems()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(item: itemdata) = viewModelScope.launch {
        repository.insetdata(item)
    }
}

class WordViewModelFactory(private val repository: Reposty) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}