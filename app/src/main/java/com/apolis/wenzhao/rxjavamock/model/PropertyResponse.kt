package com.apolis.wenzhao.rxjavamock.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PropertyResponse(
    val count: Int,
    @SerializedName("data")
    val propertyData: List<PropertyData>,
    val error: Boolean
): Serializable

data class PropertyData(
    val __v: Int? = null,
    val _id: String? = null,
    val address: String? = null,
    val city: String? = null,
    val country: String? = null,
    val image: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val mortgageInfo: Boolean? = null,
    val propertyStatus: Boolean? = null,
    val purchasePrice: String? = null,
    val state: String? = null,
    val userId: String? = null,
    val userType: String? = null
): Serializable