package com.example.joku_battle.presentation.model

data class QuizChallegeDetail(
    val title: String,
    val department: String,
    val userName: String,
    val ranking: Int,
    val rightCount: Int,
    val wrongCount: Int,
    val recommendCount: Int
)