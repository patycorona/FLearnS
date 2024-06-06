package com.example.flearns.domain.usecase

import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.data.repository.FbUserRepository
import com.example.flearns.domain.model.UserResultModel
import io.reactivex.Single
import javax.inject.Inject

class FbUserUseCase @Inject constructor(
    private var fbUserRepository: FbUserRepository
){

    fun userRegisterFirebase(userRequest: UserRequest): Single<UserResultModel> =
        fbUserRepository.userRegisterFirebase(userRequest)

    fun loginFireBase (userRequest: UserRequest) : Single<UserResultModel> =
        fbUserRepository.loginFireBase(userRequest)

}