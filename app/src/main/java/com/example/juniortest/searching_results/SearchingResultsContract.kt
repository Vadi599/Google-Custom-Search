package com.example.juniortest.searching_results

interface SearchingResultsContract {

    interface View{

        fun showMessage(message: String?)

    }

    interface Presenter{

        fun getResultsFromServer()

    }
}