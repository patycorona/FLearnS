package com.example.flearns.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultModel(
    var code: String = "",
    var message: String = "",
    val isSuccess:Boolean = false
): Parcelable
