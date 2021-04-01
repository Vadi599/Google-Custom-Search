package com.example.juniortest.searching_results

import com.example.juniortest.model.Results

interface SearchingResultsContract {

    interface View{

        fun showMessage(message: String?)

        fun showSearchingResults(results:List<Results.Item>)

    }

    interface Presenter{

        fun getResultsFromServer()

    }
}