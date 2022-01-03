package com.example.juniortest.presentation

import com.example.juniortest.model.Item
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchView : MvpView {

    fun showMessage(message: String?)

    fun showVisibility()

    fun showResults(results: List<Item?>)

    fun showLoading(show: Boolean)

}