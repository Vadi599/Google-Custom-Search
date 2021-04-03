package com.example.juniortest.search

import com.example.juniortest.model.Results

interface SearchContract {

    interface View {

        fun showMessage()

        fun showVisibility()

        fun showResults(results: List<Results.Item>)

    }

    interface Presenter {

        fun getResultsFromServer()

    }
}