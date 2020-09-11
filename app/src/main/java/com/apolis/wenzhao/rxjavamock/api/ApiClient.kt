package com.apolis.wenzhao.rxjavamock.api

import com.apolis.wenzhao.rxjavamock.model.PropertyResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {

    private const val BASE_URL = "https://apolis-property-management.herokuapp.com/api/"

    private val endPoint: EndPoint by lazy {
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        client.create(EndPoint::class.java)
    }

    interface EndPoint {
        @GET("property")
        fun getProperty(): Observable<PropertyResponse>
    }

    fun getApiEndPoint(): EndPoint = endPoint
}