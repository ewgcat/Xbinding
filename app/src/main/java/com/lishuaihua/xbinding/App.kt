package com.lishuaihua.xbinding

import android.app.Application
import com.lishuaihua.xbinding.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger(Level.DEBUG)
            androidContext(this@App)
            loadKoinModules(appModules)
        }
    }
}