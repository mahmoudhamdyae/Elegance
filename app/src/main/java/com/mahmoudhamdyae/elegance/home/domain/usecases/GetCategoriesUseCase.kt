package com.mahmoudhamdyae.elegance.home.domain.usecases

import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.core.base.BaseUseCase
import com.mahmoudhamdyae.elegance.home.domain.models.Category
import com.mahmoudhamdyae.elegance.home.domain.repository.HomeRepository

class GetCategoriesUseCase (
    private val repository: HomeRepository
) : BaseUseCase<Unit, UiState<List<Category>>>() {

    override suspend fun execute(params: Unit): UiState<List<Category>> {
        return repository.getCategories()
    }
}