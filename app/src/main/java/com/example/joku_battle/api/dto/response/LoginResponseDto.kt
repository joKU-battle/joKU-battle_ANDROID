package com.example.joku_battle.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Token,
    @SerialName("success")
    val success: Boolean
)

@Serializable
data class Token(
    @SerialName("accessToken")
    val token: String
)