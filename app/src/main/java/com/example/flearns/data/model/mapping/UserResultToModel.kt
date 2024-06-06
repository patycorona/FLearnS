package com.example.flearns.data.model.mapping

import com.example.flearns.data.model.response.UserResultResponse
import com.example.flearns.domain.model.UserResultModel

internal fun UserResultResponse.toModel() =
    UserResultModel(code = code, message = message,isSuccess = success, user = user )

