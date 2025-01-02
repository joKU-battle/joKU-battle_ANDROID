package com.example.joku_battle.presentation.navigation

import androidx.annotation.DrawableRes
import com.example.joku_battle.R

enum class BottomNavigationItem(
    @DrawableRes val iconRes: Int,
    val text: String
) {
    HOME(R.drawable.ic_home, "홈"),
    QUIZ(R.drawable.ic_quiz, "퀴즈"),
    BATTLE(R.drawable.ic_battle,"배틀"),
    MY(R.drawable.ic_my,"MY")
}