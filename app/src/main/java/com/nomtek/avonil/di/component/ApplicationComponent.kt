package com.nomtek.avonil.di.component

import android.app.Application
import android.content.Context
import com.nomtek.avonil.data.di.modules.ApiModule
import com.nomtek.avonil.data.di.modules.NetworkModule
import com.nomtek.avonil.di.modul.ApplicationModule
import com.nomtek.avonil.smartmirror.MainActivity
import com.nomtek.avonil.smartmirror.presenter.base.SchedulersProvider
import com.nomtek.domain.di.module.DomainModule
import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Damian Kwasniak on 24.08.17.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        ApiModule::class,
        DomainModule::class))
interface ApplicationComponent {

    fun context(): Context

    fun gson(): Gson

    fun application(): Application

    fun schedulersProvider(): SchedulersProvider

    fun inject(mainActivity: MainActivity)

}