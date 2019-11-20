package com.cts.avind.net

import com.cts.avind.data.main.ListData
import com.cts.avind.util.Constant
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface ApiInterface {
    /**
     * Get the list from the API
     */

    @GET(Constant.LIST_URL)
    fun getAboutList(): Observable<Single<ListData>>
}