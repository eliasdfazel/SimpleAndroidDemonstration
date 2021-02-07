package net.geeksempire.simpleandroiddemonstration

import android.app.Application
import net.geeksempire.simpleandroiddemonstration.DependencyInjection.DependencyInjectionBuilder

class SimpleApplication : Application() {

    val dependencyInjectionBuilder by lazy {
        DependencyInjectionBuilder(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()



    }

}