package ru.khalil.zimadtest.data.repository

import androidx.lifecycle.LiveData
import ru.khalil.zimadtest.data.model.Item

interface TabRepository {
    val cats: LiveData<List<Item>>
    val dogs: LiveData<List<Item>>
    fun fetchCats()
    fun fetchDogs()
}