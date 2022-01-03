package com.example.juniortest

import android.app.Application
import com.example.juniortest.di.component.AppComponent
import com.example.juniortest.di.component.DaggerAppComponent

class SearchApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()

}