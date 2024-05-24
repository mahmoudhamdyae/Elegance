package com.mahmoudhamdyae.elegance.home.data.datasource

import com.mahmoudhamdyae.elegance.home.data.entities.CategoryEntity

interface HomeRemoteDataSource {

    suspend fun getCategories(): List<CategoryEntity>
}

class HomeRemoteDataSourceImpl (
    private val apiService: HomeApiService
): HomeRemoteDataSource {
    override suspend fun getCategories(): List<CategoryEntity> =
        apiService.getCategories()
}