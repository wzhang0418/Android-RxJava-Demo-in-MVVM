package com.apolis.wenzhao.rxjavamock.viewmodel

import androidx.lifecycle.ViewModel
import com.apolis.wenzhao.rxjavamock.api.ApiClient
import com.apolis.wenzhao.rxjavamock.repository.PropertyRepository

class PropertyViewModel : ViewModel(){

    private val propertyRepository = PropertyRepository(ApiClient.getApiEndPoint())

    fun getPropertyObserver() = propertyRepository.listProperty

    fun getData() = propertyRepository.getPropertyRepo()
}