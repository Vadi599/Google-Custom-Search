package com.example.juniortest.di.module

import com.example.juniortest.fragment.SearchFragment
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {

    @Provides
    fun provideSearchFragment(): SearchFragment {
        return SearchFragment()
    }
}