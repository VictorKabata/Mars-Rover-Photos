package com.vickbt.marsrover

import android.app.Application
import com.vickbt.marsrover.di.presentationModule
import com.vickbt.network.di.networkModule
import com.vickbt.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MarsRoverApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(presentationModule, repositoryModule, networkModule)
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MarsRoverApplication)
            modules(modules)
        }
    }

}