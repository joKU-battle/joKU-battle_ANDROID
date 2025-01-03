package com.example.joku_battle.presentation.battle

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool.battleService
import com.example.joku_battle.api.dto.response.Joke
import com.example.joku_battle.presentation.model.QuizChallengeDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FunQuotesViewModel : ViewModel(){
    private val _funQuotesList = MutableStateFlow<List<Joke>>(emptyList())
    val funQuotesList: StateFlow<List<Joke>> = _funQuotesList

    fun fetchJokes(month: Int, week: Int){
        viewModelScope.launch {
            runCatching {
                battleService.getJokes(month, week)
            }.onSuccess { response ->
                if (response.success) {
                    _funQuotesList.value = response.result
                } else {
                    Log.e("BattleViewModel", "API Error: ${response.message}")
                }
            }.onFailure { error ->
                Log.e("BattleViewModel", "Network Error: ${error.message}")
            }
        }
    }

}