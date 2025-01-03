package com.example.joku_battle.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizzesResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: List<QuizzeData>,
    @SerialName("success")
    val success: Boolean
)

@Serializable
data class QuizzeData(
    @SerialName("quizId")
    val quizId: Int,
    @SerialName("question")
    val question: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("userName")
    val userName: String,
    @SerialName("userDepartment")
    val userDepartment: String,
    @SerialName("recommendation")
    val recommendation: Int
)