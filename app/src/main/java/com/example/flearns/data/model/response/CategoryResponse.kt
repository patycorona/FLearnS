package com.example.flearns.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @SerializedName("id") val id  : Int = 0,
    @SerializedName("name") val name : String = "",
    @SerializedName("image") val image : String = ""
)
