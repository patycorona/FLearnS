package com.example.flearns.data.model.response

import com.google.gson.annotations.SerializedName

data class UserResultResponse (
    @SerializedName("code") val code: String = "",
    @SerializedName("message") val message: String = "",
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("user") val user: String = ""
)