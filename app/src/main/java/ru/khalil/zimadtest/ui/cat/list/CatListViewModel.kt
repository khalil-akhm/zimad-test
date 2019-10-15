package ru.khalil.zimadtest.ui.cat.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.data.repository.TabRepository

class CatListViewModel(private val repository: TabRepository) : ViewModel() {

    val cats: LiveData<List<Item>> = Transformations.map(repository.cats){it}

    init {
        updateCats()
    }

    private fun updateCats(){
        repository.fetchCats()
    }
}
