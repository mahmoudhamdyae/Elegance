package com.mahmoudhamdyae.elegance.core.di

import com.mahmoudhamdyae.elegance.home.data.datasource.HomeRemoteDataSource
import com.mahmoudhamdyae.elegance.home.data.datasource.HomeRemoteDataSourceImpl
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataSourceModule = module {
    single<HomeRemoteDataSource> {
        HomeRemoteDataSourceImpl(get<HttpClient>())
    }
}