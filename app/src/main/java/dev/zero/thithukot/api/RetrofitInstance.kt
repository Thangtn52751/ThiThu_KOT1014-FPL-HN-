package dev.zero.thithukot.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: CatApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://cataas.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApiService::class.java)
    }
}
