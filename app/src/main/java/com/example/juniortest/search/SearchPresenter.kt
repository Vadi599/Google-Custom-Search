package com.example.juniortest.search

import android.content.Context
import com.example.juniortest.model.Results
import com.example.juniortest.network.AppApiClient
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SearchPresenter(private val view: SearchContract.View, context: Context?) :
    SearchContract.Presenter,

    SingleObserver<Results> {

    private val appApiClient = AppApiClient.get()


    override fun getResultsFromServer() {
        appApiClient.results.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(this)
    }

    override fun onSuccess(t: Results) {
        val resultsList = t.items
        view.showResults(resultsList)
    }

    override fun onError(e: Throwable) {
        view.showMessage(e.message)
    }

    override fun onSubscribe(d: Disposable) {

    }
}
