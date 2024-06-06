package com.example.flearns.data.model.mapping

import com.example.flearns.data.model.response.ResultResponse
import com.example.flearns.domain.model.ResultModel

internal fun ResultResponse.toModel() =
    ResultModel(code = code, message = message,isSuccess = success)