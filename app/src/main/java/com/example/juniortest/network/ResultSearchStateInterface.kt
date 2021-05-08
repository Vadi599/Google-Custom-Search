package com.example.juniortest.network

import com.example.juniortest.model.ResultSearchState
import com.example.juniortest.model.Results
import io.reactivex.Single

interface ResultSearchStateInterface {
    fun getResponse(myQuery: String): Single<Results>
}