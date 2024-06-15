package com.example.flearns.data.network

import com.example.flearns.data.model.response.AllCatClassResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoreHomeApi {

    @GET("/cat_spanish_class")
    @Headers("Content-Type: application/json ")
    fun getAllCatClass(): Single<AllCatClassResponse>

}