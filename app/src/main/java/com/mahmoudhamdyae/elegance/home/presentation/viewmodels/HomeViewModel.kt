package com.mahmoudhamdyae.elegance.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.core.base.BaseUseCase
import com.mahmoudhamdyae.elegance.home.domain.models.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel (
    private val useCase: BaseUseCase<Unit, UiState<List<Category>>>
): ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            val result = useCase.execute(Unit)
            _uiState.update {
                when (result) {
                    is UiState.Success -> HomeUiState(categoriesUiState = UiState.Success(result.data))
                    is UiState.Error -> HomeUiState(categoriesUiState = UiState.Error(result.message))
                    else -> HomeUiState(categoriesUiState = UiState.Loading())
                }
            }
        }
    }
}