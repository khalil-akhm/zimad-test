package ru.khalil.zimadtest.ui.dog.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.data.repository.TabRepository

class DogListViewModel(private val repository: TabRepository) : ViewModel() {

    val dogs: LiveData<List<Item>> = Transformations.map(repository.dogs){it}

    init {
        updateDogs()
    }

    private fun updateDogs(){
        repository.fetchDogs()
    }

}
