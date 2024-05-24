package com.mahmoudhamdyae.elegance.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.gson.gson
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> {
        HttpClient(CIO) {
            install(Logging) {
//                logger = Logger.DEFAULT
//                level = LogLevel.HEADERS
//                filter { request ->
//                    request.url.host.contains("ktor.io")
//                }
//                sanitizeHeader { header -> header == HttpHeaders.Authorization }
            }
            install(ContentNegotiation) {
                gson()
            }
        }
    }
}