package com.example.flearns.data.database

import com.example.flearns.data.model.request.UserRequest
import com.example.flearns.data.model.response.UserResultResponse
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.model.ConstantGeneral.Companion.ERROR
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_ERROR
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_ERROR_AUTH
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_LOGIN_SUCCESS
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_REGISTER_SUCCESS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Single
import javax.inject.Inject

class FirebaseAction @Inject constructor() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    fun userRegisterFirebase(userRequest: UserRequest) : Single<UserResultResponse> {
        var userRegisterResponse = UserResultResponse(CODE, MSG_REGISTER_SUCCESS, true)
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userRequest.email, userRequest.pwd)
            .addOnCompleteListener(){ task ->
                userRegisterResponse =
                    if (task.isSuccessful) UserResultResponse(CODE, MSG_REGISTER_SUCCESS, true)
                    else UserResultResponse(ERROR, MSG_ERROR, false)
            }
        return Single.just(userRegisterResponse)
    }

    fun loginFireBase(userRequest: UserRequest): Single<UserResultResponse> {
        var userResponse = UserResultResponse(CODE, MSG_LOGIN_SUCCESS, true, userRequest.email)

        firebaseAuth.signInWithEmailAndPassword(userRequest.email, userRequest.pwd)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful){
                    userResponse = UserResultResponse(CODE, MSG_LOGIN_SUCCESS, true,userRequest.email)
                    val user = task.result.user
                    updateUI(user)
                } else{
                    UserResultResponse(ERROR, MSG_ERROR_AUTH, false )
                    val user = task.result.user
                    updateUI(null)
                }
            }

        return Single.just(userResponse)
    }

    private fun updateUI(user: FirebaseUser?) {
        user?.let {
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl
            val emailVerified = it.isEmailVerified
            val uid = it.uid
        }
    }




}