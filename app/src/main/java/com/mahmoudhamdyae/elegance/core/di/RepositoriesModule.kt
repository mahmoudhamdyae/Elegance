package com.mahmoudhamdyae.elegance.core.di

import com.mahmoudhamdyae.elegance.home.data.repository.HomeRepositoryImpl
import com.mahmoudhamdyae.elegance.home.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(get())
    }
}