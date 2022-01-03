package com.example.juniortest.di.component

import com.example.juniortest.activity.MainActivity
import com.example.juniortest.di.module.SearchFragmentModule
import dagger.Component

@Component(modules = [SearchFragmentModule::class])
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}