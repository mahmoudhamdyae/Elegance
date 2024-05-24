package com.mahmoudhamdyae.elegance.home.domain.repository

import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.home.domain.models.Category

interface HomeRepository {
    suspend fun getCategories(): UiState<List<Category>>
}