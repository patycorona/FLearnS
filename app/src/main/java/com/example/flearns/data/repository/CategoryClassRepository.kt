package com.example.flearns.data.repository

import com.example.flearns.domain.model.CategoryModel
import io.reactivex.Single

interface CategoryClassRepository {
    fun getAllCatClass(): Single<MutableList<CategoryModel>>
}