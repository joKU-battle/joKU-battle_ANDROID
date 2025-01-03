package com.example.joku_battle.presentation.worldcup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.dto.request.AddBattleRequestDto
import com.example.joku_battle.api.dto.response.Content
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WorldCupViewModel: ViewModel(){
    private val worldCupService by lazy { ServicePool.worldCupService }

    private val _participantList = MutableStateFlow<MutableList<Content>>(mutableListOf(
        Content(1,"1"),
        Content(2,"2"),
        Content(3,"3"),
        Content(4,"4"),
        Content(5,"5"),
        Content(6,"6"),
        Content(7,"7"),
        Content(8,"8")
    ))
    val participantList: StateFlow<MutableList<Content>> = _participantList.asStateFlow()

    private val _qulifyingRound = MutableStateFlow("8강")
    val qualifiyingRound: StateFlow<String> = _qulifyingRound.asStateFlow()

    private val _round = MutableStateFlow(1)
    val round: StateFlow<Int> = _round.asStateFlow()

    private val _totalRound = MutableStateFlow(4)
    val totalRound: StateFlow<Int> = _totalRound.asStateFlow()

    fun getParticipants(){
        viewModelScope.launch {
            runCatching {
                worldCupService.getParticipants()
            }.onSuccess { response ->
                _participantList.value = response.result.toMutableList()
                Log.d("zzz",_participantList.value.toString())
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}