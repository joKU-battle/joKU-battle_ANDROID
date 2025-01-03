package com.example.joku_battle.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JokesDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: List<Joke>
)

@Serializable
data class Joke(
    @SerialName("joIdx")
    val joIdx: Int,
    @SerialName("content")
    val content: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("userName")
    val userName: String,
    @SerialName("userDepartment")
    val userDepartment: String,
    @SerialName("pickedCount")
    val pickedCount: Int
)