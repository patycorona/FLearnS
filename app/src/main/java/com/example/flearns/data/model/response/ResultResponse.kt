package com.example.flearns.data.model.response

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("code") val code: String = "",
    @SerializedName("message") val message: String = "",
    @SerializedName("success") val success: Boolean = false
)