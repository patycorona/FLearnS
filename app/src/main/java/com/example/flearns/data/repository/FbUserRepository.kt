package com.example.flearns.data.repository

import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.domain.model.ResultModel
import io.reactivex.Single

interface FbUserRepository {

    fun userRegisterFirebase(userRequest: UserRequest): Single<ResultModel>
}