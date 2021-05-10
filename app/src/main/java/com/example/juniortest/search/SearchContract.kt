package com.example.juniortest.search

import com.example.juniortest.model.Results

interface SearchContract {

    interface View {

        fun showMessage(message: String?)

        fun showVisibility()

        fun showResults(results: List<Results.Item>)

        fun showLoading(show: Boolean)
    }

    interface Presenter {

        fun getResultsFromServer(query: String)

        fun isNetworkAvailable(): Boolean
    }
}