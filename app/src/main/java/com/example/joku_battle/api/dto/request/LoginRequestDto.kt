package com.example.joku_battle.api.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    @SerialName("id")
    val id: String,
    @SerialName("password")
    val password: String
)