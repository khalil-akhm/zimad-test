package ru.khalil.zimadtest.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.khalil.zimadtest.data.model.Response

interface ZimadApiService {

    @GET("api.php?query=cat")
    fun getCatsAsync (): Deferred<Response>

    @GET("api.php?query=dog")
    fun getDogsAsync (): Deferred<Response>

    companion object Factory{
        private const val BASE_URL = "http://kot3.com/xim/"

        operator fun invoke(): ZimadApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory((GsonConverterFactory.create()))
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ZimadApiService::class.java)
        }
    }
}