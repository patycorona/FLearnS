package com.example.flearns.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CategoryModel (
    val id:Int = 0,
    val name:String = "",
    val image:String = ""
): Parcelable