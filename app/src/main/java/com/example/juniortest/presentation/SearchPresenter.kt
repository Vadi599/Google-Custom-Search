package com.example.juniortest.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import com.example.juniortest.model.Results
import com.example.juniortest.network.AppApiClient
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SearchPresenter(
    val context: Context
) : MvpPresenter<SearchView>() {

    private val appApiClient = AppApiClient

    @SuppressLint("MissingPermission")
    private fun isNetworkAvailable(): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

    fun getResultsFromServer(query: String) {
        if (isNetworkAvailable()) {
            viewState.showMessage("Поиск результатов запроса")
            viewState.showVisibility()
            viewState.showLoading(true)
            return appApiClient.instance.getResponse(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Results> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onSuccess(results: Results) {
                        val resultsList = results.items
                        viewState.showLoading(false)
                        if (resultsList == null) {
                            viewState.showMessage("По вашему запросу ничего не найдено")
                        } else {
                            viewState.showResults(resultsList)
                        }
                    }

                    override fun onError(e: Throwable) {
                        viewState.showMessage("Ошибка!По вашему запросу ничего не найдено." + e.message)
                        viewState.showLoading(false)
                    }
                })
        } else {
            viewState.showMessage("Нет интернета!")
        }
    }
}
