package com.example.flearns.data.model.response

import com.google.gson.annotations.SerializedName

data class AllCatClassResponse(
    @SerializedName("message") val message : String = "",
    @SerializedName("is_success") val isSuccess : Boolean = false,
    @SerializedName("category") val category: MutableList<CategoryResponse> = mutableListOf()
)
