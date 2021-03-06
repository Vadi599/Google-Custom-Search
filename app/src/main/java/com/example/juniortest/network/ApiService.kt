package com.example.juniortest.network

import com.example.juniortest.model.Results
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/customsearch/v1")
    fun getResults(
        @Query("key") myApiKey: String? = null,
        @Query("cx") myIdAccess: String? = null,
        @Query("q") myQuery: String
    ): Single<Results>
}