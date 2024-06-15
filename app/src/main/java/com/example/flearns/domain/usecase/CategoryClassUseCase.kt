package com.example.flearns.domain.usecase

import com.example.flearns.data.repository.CategoryClassRepositoryImpl
import com.example.flearns.domain.model.CategoryModel
import io.reactivex.Single
import javax.inject.Inject

class CategoryClassUseCase @Inject constructor(
    private var catClassRepositoryImpl: CategoryClassRepositoryImpl
) {
    fun getAllCatClass(): Single<MutableList<CategoryModel>> =
        catClassRepositoryImpl.getAllCatClass()
}