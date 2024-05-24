package com.mahmoudhamdyae.elegance.core.di

import com.mahmoudhamdyae.elegance.core.network.ApiConstants
import com.mahmoudhamdyae.elegance.home.data.datasource.HomeApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single<OkHttpClient>{
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASE_URL)
            .build()
    }

    single<HomeApiService> {
        get<Retrofit>().create(HomeApiService::class.java)
    }
}