package com.route.islami.api

import com.route.islami.api.modal.radiosResponse.RadiosItemsResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
    @GET("api/v3/radios")
   fun getRadioApis():Call<RadiosItemsResponse>
}