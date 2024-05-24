package com.mahmoudhamdyae.elegance.home.presentation.viewmodels

import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.home.domain.models.Category

data class HomeUiState(
    val categoriesUiState: UiState<List<Category>> = UiState.Loading(),
)
