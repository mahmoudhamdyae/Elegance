package com.mahmoudhamdyae.elegance.home.data.datasource

import com.mahmoudhamdyae.elegance.home.data.entities.CategoriesEntity
import retrofit2.http.GET

interface HomeApiService {

    @GET("categories.json")
    suspend fun getCategories(): CategoriesEntity
}