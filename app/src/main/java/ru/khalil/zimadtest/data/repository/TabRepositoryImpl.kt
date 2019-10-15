package ru.khalil.zimadtest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.data.network.ZimadApiService
import java.lang.Exception

class TabRepositoryImpl(
    private val apiService: ZimadApiService
): TabRepository {
    private val _cats = MutableLiveData<List<Item>>()
    override val cats: LiveData<List<Item>> = _cats

    private val _dogs = MutableLiveData<List<Item>>()
    override val dogs: LiveData<List<Item>> = _dogs

    override fun fetchCats(){
        GlobalScope.launch {
            try {
                val cats = apiService.getCatsAsync().await()
                _cats.postValue(cats.data)
            } catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun fetchDogs(){
        GlobalScope.launch {
            try {
                val dogs = apiService.getDogsAsync().await()
                _dogs.postValue(dogs.data)
            } catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}