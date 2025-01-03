package com.example.joku_battle.api.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class AddQuizRequestDto(
    val question: String,
    val answer: String
)
