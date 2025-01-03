package com.example.joku_battle.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Quiz : Route

    @Serializable
    data object Battle : Route

    @Serializable
    data object My : Route

    @Serializable
    data object QuizChallenge : Route

    @Serializable
    data object BattleChallenge : Route

    @Serializable
    data object QuizAdd : Route
}