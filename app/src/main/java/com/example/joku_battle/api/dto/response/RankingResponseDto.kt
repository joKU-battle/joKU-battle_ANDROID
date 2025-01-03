package com.example.joku_battle.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankingResponseDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: List<RankingUser>
)

@Serializable
data class RankingUser(
    @SerialName("name")
    val name: String,
    @SerialName("department")
    val department: String,
    @SerialName("score")
    val score: Int,
    @SerialName("image")
    val image: String?
)
