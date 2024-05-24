package com.mahmoudhamdyae.elegance.core.di

import org.koin.dsl.module

import com.mahmoudhamdyae.elegance.home.data.datasource.HomeApiService
import com.mahmoudhamdyae.elegance.home.data.datasource.HomeRemoteDataSource
import com.mahmoudhamdyae.elegance.home.data.datasource.HomeRemoteDataSourceImpl

val dataSourceModule = module {
    single<HomeRemoteDataSource> {
        HomeRemoteDataSourceImpl(get<HomeApiService>())
    }
}