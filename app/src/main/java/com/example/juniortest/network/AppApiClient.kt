package com.example.juniortest.network

import com.example.juniortest.model.Results
import com.example.juniortest.network.ServiceGenerator.apiService
import io.reactivex.Single


class AppApiClient(private val apiService: ApiService) : ResultSearchStateInterface {

    override fun getResponse(myQuery: String): Single<Results> {
        return apiService.getResults(
            myApiKey = "AIzaSyC3dQDrC-QQlvr5E5_tgMCX_OJbJKGkSmY",
            myIdAccess = "ed4f51c91f68e70ec",
            myQuery = myQuery
        )
    }

    companion object {
        var instance = AppApiClient(apiService)
        fun get(): AppApiClient {
            return instance
        }
    }
}