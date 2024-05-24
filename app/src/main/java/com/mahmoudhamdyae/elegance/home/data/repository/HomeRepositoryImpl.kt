package com.mahmoudhamdyae.elegance.home.data.repository

import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.home.data.datasource.HomeRemoteDataSource
import com.mahmoudhamdyae.elegance.home.data.mappers.toCategories
import com.mahmoudhamdyae.elegance.home.domain.models.Category
import com.mahmoudhamdyae.elegance.home.domain.repository.HomeRepository

class HomeRepositoryImpl (
    private val homeRemoteDataSource: HomeRemoteDataSource
): HomeRepository {
    override suspend fun getCategories(): UiState<List<Category>> {
        return try {
            UiState.Success(homeRemoteDataSource.getCategories().toCategories())
        } catch (e: Exception) {
            e.printStackTrace()
            UiState.Error(e.message ?: "Error: ${e.message}")
        }
    }
}