package com.example.joku_battle.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: MyData,
    @SerialName("success")
    val success: Boolean
)

@Serializable
data class MyData(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("department")
    val department: String,
    @SerialName("title")
    val title: titleData
)

@Serializable
data class titleData(
    @SerialName("name")
    val name: String,
    @SerialName("month")
    val month: Int,
    @SerialName("week")
    val week: Int
)