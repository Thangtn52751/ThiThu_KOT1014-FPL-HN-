package dev.zero.thithukot.api

import dev.zero.thithukot.model.Cat
import retrofit2.http.GET

interface CatApiService {
    @GET("cats?tags=cute&skip=0&limit=10")
    suspend fun getCats(): List<Cat>
}
