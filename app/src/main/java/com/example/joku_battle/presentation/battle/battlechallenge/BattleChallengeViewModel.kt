package com.example.joku_battle.presentation.battle.battlechallenge

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.dto.request.AddBattleRequestDto
import com.example.joku_battle.api.dto.request.AddQuizRequestDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BattleChallengeViewModel : ViewModel() {

    private val battleService by lazy { ServicePool.battleService }

    private val _battleChallengeRanking = MutableStateFlow<Int?>(null)
    val battleChallengeRanking: StateFlow<Int?> = _battleChallengeRanking.asStateFlow()

    private val _content = MutableStateFlow("")
    val content: StateFlow<String> = _content.asStateFlow()

    fun updateContent(content: String) {
        _content.value = content
    }

    fun addBattle() {
        viewModelScope.launch {
            runCatching {
                battleService.addBattle(
                    AddBattleRequestDto(
                        content = content.value
                    )
                )
            }.onSuccess { response ->
                Log.d("zz","성공")
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }

    init {
        loadBattleChallengeDetail()
    }

    private fun loadBattleChallengeDetail() {
        _battleChallengeRanking.value = 4
    }
}