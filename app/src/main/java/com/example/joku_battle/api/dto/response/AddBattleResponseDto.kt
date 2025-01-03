package com.example.joku_battle.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AddBattleResponseDto(
    val success: Boolean,
    val code: Int,
    val message: String,
    val result: Result
)

@Serializable
data class Result(
    val joIdx: Int,
    val content: String,
    val createdAt: String,
    val userName: String,
    val userDepartment: String,
    val pickedCount: Int
)