package com.mahmoudhamdyae.elegance.core.di

import com.mahmoudhamdyae.elegance.home.domain.usecases.GetCategoriesUseCase
import com.mahmoudhamdyae.elegance.home.presentation.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelsModule = module {
    viewModel<HomeViewModel> {
        HomeViewModel(get<GetCategoriesUseCase>())
    }
}