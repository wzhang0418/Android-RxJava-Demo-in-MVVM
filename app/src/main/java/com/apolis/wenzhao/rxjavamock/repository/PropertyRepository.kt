package com.apolis.wenzhao.rxjavamock.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apolis.wenzhao.rxjavamock.api.ApiClient
import com.apolis.wenzhao.rxjavamock.model.PropertyData
import com.apolis.wenzhao.rxjavamock.model.PropertyResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PropertyRepository (private val endPoint: ApiClient.EndPoint) {

    val listProperty: MutableLiveData<List<PropertyData>?> by lazy {
        MutableLiveData<List<PropertyData>?>()
    }

    fun getPropertyRepo(){

        val observer = object : Observer<PropertyResponse> {

            override fun onComplete() {
                Log.d("MYTAG", "onComplete()")
            }

            override fun onNext(propertyResponse: PropertyResponse) {
                listProperty.postValue(propertyResponse.propertyData)
                Log.d("MYTAG", "onNext()")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("MYTAG", "onSubscribe()")
            }

            override fun onError(e: Throwable) {
                Log.d("MYTAG", "onError()")
                Log.d("MYTAG", e.message.toString())
            }
        }

        val observable = endPoint.getProperty()

        observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(observer)
    }
}