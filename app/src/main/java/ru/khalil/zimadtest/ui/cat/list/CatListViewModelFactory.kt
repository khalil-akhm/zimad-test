package ru.khalil.zimadtest.ui.cat.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.khalil.zimadtest.data.repository.TabRepository

class CatListViewModelFactory(
    private val repository: TabRepository
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatListViewModel::class.java)) {
            return CatListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}