package com.nomtek.avonil.smartmirror

import android.app.Application
import android.content.res.Configuration
import com.nomtek.avonil.data.di.modules.ApiModule
import com.nomtek.avonil.di.component.ApplicationComponent
import com.nomtek.avonil.di.component.DaggerApplicationComponent
import com.nomtek.avonil.di.modul.ApplicationModule
import java.util.*


/**
 * Created by avonil on 9/18/17.
 */

class SmartMirrorApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent

        lateinit var instance: SmartMirrorApplication
            private set
    }

    private val WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/"

    private val QUOTE_API_URL = "http://165.227.131.50/"

    override fun onCreate() {
        super.onCreate()
        prepareApplicationComponent()
        instance = this

        val res = resources
        val config = Configuration(res.configuration)
        config.locale = Locale("pl")
        res.updateConfiguration(config, res.displayMetrics)
    }

    private fun prepareApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .apiModule(ApiModule(WEATHER_API_URL, QUOTE_API_URL)).build()
    }


}