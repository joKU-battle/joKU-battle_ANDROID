package com.example.joku_battle.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class GetParticipantsResponseDto(
    val success: Boolean,
    val code: Int,
    val message: String,
    val result: List<Content>
)

@Serializable
data class Content(
    val joIdx: Int,
    val content: String
)
