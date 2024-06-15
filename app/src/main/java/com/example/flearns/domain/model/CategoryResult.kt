package com.example.flearns.domain.model

class CategoryResult (
    var message : String = "",
    var isSuccess : Boolean = false,
    var category: MutableList<CategoryModel> = mutableListOf()
)