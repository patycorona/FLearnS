package com.example.flearns.data.repository

import com.example.flearns.data.database.FirebaseAction
import com.example.flearns.data.model.mapping.toModel
import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.domain.model.ResultModel
import io.reactivex.Single

class FbUserRepositoryImpl(
    private var firebaseAction: FirebaseAction
):FbUserRepository{

    override fun userRegisterFirebase(userRequest: UserRequest): Single<ResultModel> =
        firebaseAction.userRegisterFirebase(userRequest)
            .map { resultResponse ->
                resultResponse.toModel()
            }
}

