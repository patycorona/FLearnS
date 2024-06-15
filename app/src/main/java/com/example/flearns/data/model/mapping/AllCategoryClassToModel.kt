package com.example.flearns.data.model.mapping

import com.example.flearns.data.model.response.AllCatClassResponse
import com.example.flearns.domain.model.CategoryModel

fun AllCatClassResponse.toModel(): MutableList<CategoryModel> {
    val list: MutableList<CategoryModel> = mutableListOf()

    category.map { cat ->
        list.add(
            CategoryModel(
                id = cat.id,
                name = cat.name,
                image = cat.image
            )
        )
    }
    return list
}