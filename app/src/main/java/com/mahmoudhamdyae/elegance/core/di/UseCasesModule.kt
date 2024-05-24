package com.mahmoudhamdyae.elegance.core.di

import com.mahmoudhamdyae.elegance.home.domain.repository.HomeRepository
import com.mahmoudhamdyae.elegance.home.domain.usecases.GetCategoriesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single<GetCategoriesUseCase> {
        GetCategoriesUseCase(get<HomeRepository>())
    }
}