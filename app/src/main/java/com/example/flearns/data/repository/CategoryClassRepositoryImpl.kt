package com.example.flearns.data.repository

import com.example.flearns.data.model.mapping.toModel
import com.example.flearns.data.network.CoreHomeApi
import com.example.flearns.domain.model.CategoryModel
import io.reactivex.Single
import javax.inject.Inject

class CategoryClassRepositoryImpl @Inject constructor(
    private var coreHomeApi: CoreHomeApi
): CategoryClassRepository {

    override fun getAllCatClass(): Single<MutableList<CategoryModel>> =
        coreHomeApi.getAllCatClass()
            .map { allCatClassResponse ->
                allCatClassResponse.toModel()
            }
}