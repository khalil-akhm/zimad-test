package ru.khalil.zimadtest.ui.dog.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.khalil.zimadtest.data.repository.TabRepository

class DogListViewModelFactory(
    private val repository: TabRepository
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogListViewModel::class.java)) {
            return DogListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}