package com.example.juniortest.main

import com.example.juniortest.model.Results
import com.example.juniortest.searching_results.SearchingResultsFragment

interface MainContract {

    interface View {

        fun showMessage()

        fun showSearchingResults()
    }
}