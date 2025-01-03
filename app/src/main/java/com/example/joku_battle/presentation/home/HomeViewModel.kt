package com.example.joku_battle.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.dto.response.RankingUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){
    private val rankingService by lazy { ServicePool.rankingService }

    private val _rankingList = MutableStateFlow<List<RankingUser>>(emptyList())
    val rankingList: StateFlow<List<RankingUser>> = _rankingList.asStateFlow()

    fun fetchRanking() {
        viewModelScope.launch {
            runCatching {
                rankingService.getRanking()
            }.onSuccess { response ->
                if (response.success) {
                    _rankingList.value = response.result
                } else {
                    Log.e("RankingViewModel", "API Error: ${response.message}")
                }
            }.onFailure { error ->
                Log.e("RankingViewModel", "Network Error: ${error.message}")
            }
        }
    }
}
