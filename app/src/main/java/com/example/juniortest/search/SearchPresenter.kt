package com.example.juniortest.search

import android.content.Context
import android.net.ConnectivityManager
import com.example.juniortest.model.Results
import com.example.juniortest.network.AppApiClient
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * public class SearchPresenter {
 *
 *  private View view;
 *  public Context context;
 *
 *  public SearchPresenter(View view, Context context){
 *      this.view = view;
 *      this.context = context;
 *  }
 *
 * }
 */

class SearchPresenter(
    private val view: SearchContract.View,
    val context: Context
) :
    SearchContract.Presenter {
    private val appApiClient = AppApiClient

    override fun isNetworkAvailable(): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

    override fun getResultsFromServer(query: String) {
        if (isNetworkAvailable()) {
            view.showMessage("Поиск результатов запроса")
            view.showVisibility()
            return appApiClient.instance.getResponse(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Results> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onSuccess(t: Results) {
                        val resultsList = t.items
                        view.showResults(resultsList)
                    }

                    override fun onError(e: Throwable) {
                        view.showMessage(e.message)
                    }
                })
        } else {
            view.showMessage("Нет интернета!")
        }
    }
}
