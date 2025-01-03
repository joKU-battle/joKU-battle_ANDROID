package com.example.joku_battle.api.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class AddBattleRequestDto(
    val content: String
)