package com.example.flearns.data.model.request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("email") val email:String,
    @SerializedName("password") val pwd:String,
)
