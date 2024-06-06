package com.example.flearns.ui.user.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flearns.R
import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.domain.model.ConstantGeneral.Companion.ERROR
import com.example.flearns.domain.model.ResultModel
import com.example.flearns.domain.model.UserModel
import com.example.flearns.domain.usecase.FbUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FbUserViewModel @Inject constructor(
    private var fbUserUseCase: FbUserUseCase
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val userResultModel: MutableLiveData<ResultModel> by lazy {
        MutableLiveData<ResultModel>()
    }

    fun userRegisterFirebase(userModel: UserModel){
        val userModel = UserRequest(email = userModel.email, pwd = userModel.pwd)

        compositeDisposable += fbUserUseCase.userRegisterFirebase(userModel)
            .subscribeOn(Schedulers.io())
            .subscribe({ userRegister ->
                userResultModel.postValue(userRegister)
            }, {
                userResultModel.postValue(
                    ResultModel(
                        code = ERROR,
                        message = R.string.msg_error.toString(),
                        isSuccess = false
                    )
                )
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}