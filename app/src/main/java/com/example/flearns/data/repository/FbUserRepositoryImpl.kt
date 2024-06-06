package com.example.flearns.data.repository

import com.example.flearns.data.database.FirebaseAction
import com.example.flearns.data.model.mapping.toModel
import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.data.model.response.UserResultResponse
import com.example.flearns.domain.model.UserResultModel
import io.reactivex.Single

class FbUserRepositoryImpl(
    private var firebaseAction: FirebaseAction
):FbUserRepository {

    override fun userRegisterFirebase(userRequest: UserRequest): Single<UserResultModel> =
        firebaseAction.userRegisterFirebase(userRequest)
            .map {resultModel ->
                resultModel.toModel()
            }

    override fun loginFireBase (userRequest: UserRequest) : Single<UserResultModel> =
        firebaseAction.loginFireBase(userRequest)
            .map{ resultModel ->
                resultModel.toModel()
            }
}

