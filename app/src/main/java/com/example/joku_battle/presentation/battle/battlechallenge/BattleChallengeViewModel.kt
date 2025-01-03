package com.example.joku_battle.presentation.battle.battlechallenge

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BattleChallengeViewModel : ViewModel() {
    private val _battleChallengeRanking = MutableStateFlow<Int?>(null)
    val battleChallengeRanking: StateFlow<Int?> = _battleChallengeRanking.asStateFlow()

    init {
        loadBattleChallengeDetail()
    }

    private fun loadBattleChallengeDetail() {
        _battleChallengeRanking.value = 4
    }
}