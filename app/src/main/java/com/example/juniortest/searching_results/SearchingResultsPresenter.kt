package com.example.juniortest.searching_results

import android.content.Context
import com.example.juniortest.main.MainContract
import com.example.juniortest.model.Results
import com.example.juniortest.network.AppApiClient
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchingResultsPresenter(
    private val view: SearchingResultsContract.View, context: Context?) : SearchingResultsContract.Presenter, SingleObserver<Results> {

    private val appApiClient = AppApiClient.get()

    override fun getResultsFromServer() {
        appApiClient.results.doOnSuccess()subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(this)
    }

    override fun onSuccess(t: Results) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {

    }
}