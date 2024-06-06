package com.example.flearns.data.database

import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.data.model.response.ResultResponse
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.model.ConstantGeneral.Companion.ERROR
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_ERROR
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_REGISTER_SUCCESS
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import javax.inject.Inject

class FirebaseAction @Inject constructor() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    fun userRegisterFirebase(userRequest: UserRequest) : Single<ResultResponse> {
        var userRegisterResponse = ResultResponse(CODE, MSG_REGISTER_SUCCESS, true)
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userRequest.email, userRequest.pwd)
            .addOnCompleteListener(){ task ->
                userRegisterResponse =
                    if (task.isSuccessful) ResultResponse(CODE, MSG_REGISTER_SUCCESS, true)
                    else ResultResponse(ERROR, MSG_ERROR, false)
            }
        return Single.just(userRegisterResponse)
    }


}