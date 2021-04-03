package com.example.juniortest.network

import com.example.juniortest.model.Results
import io.reactivex.Single


class AppApiClient {
    val results: Single<Results.Item>
        get() = ServiceGenerator.apiService.getResults(
            myApiKey = "AIzaSyC3dQDrC-QQlvr5E5_tgMCX_OJbJKGkSmY",
            myIdAccess = "ed4f51c91f68e70ec",
            myQuery = "query"
        )

    companion object {
        var instance = AppApiClient()
        fun get(): AppApiClient {
            return instance
        }
    }
}