package com.example.flearns.domain.usecase

import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.data.repository.FbUserRepository
import com.example.flearns.domain.model.ResultModel
import io.reactivex.Single
import javax.inject.Inject

class FbUserUseCase @Inject constructor(
    private var fbUserRepository: FbUserRepository
){

    fun userRegisterFirebase(userRequest: UserRequest): Single<ResultModel> =
        fbUserRepository.userRegisterFirebase(userRequest)

}