package com.example.flearns.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResultModel(
    var code: String = "",
    var message: String = "",
    var isSuccess:Boolean = false,
    var user:String = ""
): Parcelable
