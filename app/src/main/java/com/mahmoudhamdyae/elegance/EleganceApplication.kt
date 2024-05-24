package com.mahmoudhamdyae.elegance

import android.app.Application
import com.mahmoudhamdyae.elegance.core.di.ViewModelsModule
import com.mahmoudhamdyae.elegance.core.di.dataSourceModule
import com.mahmoudhamdyae.elegance.core.di.networkModule
import com.mahmoudhamdyae.elegance.core.di.repositoryModule
import com.mahmoudhamdyae.elegance.core.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class EleganceApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@EleganceApplication)
            modules(
                networkModule,
                dataSourceModule,
                repositoryModule,
                useCasesModule,
                ViewModelsModule
            )
        }
    }
}