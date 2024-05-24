package com.mahmoudhamdyae.elegance.home.data.datasource

import com.mahmoudhamdyae.elegance.core.network.ApiConstants
import com.mahmoudhamdyae.elegance.home.data.entities.CategoryEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface HomeRemoteDataSource {

    suspend fun getCategories(): List<CategoryEntity>
}

class HomeRemoteDataSourceImpl (
    private val client: HttpClient
): HomeRemoteDataSource {

    override suspend fun getCategories(): List<CategoryEntity> {
        val response = client.get(ApiConstants.GET_CATEGORIES_PATH)
        return response.body()
    }
}