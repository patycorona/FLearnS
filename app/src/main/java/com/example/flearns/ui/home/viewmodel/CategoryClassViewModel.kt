package com.example.flearns.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flearns.domain.model.CategoryResult
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.usecase.CategoryClassUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CategoryClassViewModel @Inject constructor(
    private var categoryClassUseCase: CategoryClassUseCase
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val categoryResultObserver: MutableLiveData<CategoryResult> by lazy {
        MutableLiveData<CategoryResult>()
    }

    fun getAllCatClass(){

        compositeDisposable += categoryClassUseCase.getAllCatClass()
            .subscribeOn(Schedulers.io())
            .subscribe({ list_cat ->
                categoryResultObserver.postValue(
                    CategoryResult(
                        message = CODE,
                        isSuccess = true,
                        category = list_cat
                    )
                )
            }, {
                categoryResultObserver.postValue(
                    CategoryResult(
                        isSuccess = false
                    )
                )
            })
    }


}