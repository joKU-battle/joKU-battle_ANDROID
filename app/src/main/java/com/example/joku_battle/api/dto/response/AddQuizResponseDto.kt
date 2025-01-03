package com.example.joku_battle.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AddQuizResponseDto(
    val quizId: Int,
    val question: String,
    val createdAt: String,
    val userName: String,
    val userDepartment: String,
    val recommendation: Int
)
