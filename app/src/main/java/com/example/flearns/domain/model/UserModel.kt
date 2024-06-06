package com.example.flearns.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserModel(
    var email:String = "",
    var pwd:String = ""
): Parcelable