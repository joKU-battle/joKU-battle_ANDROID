package com.example.joku_battle.presentation.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.dto.response.QuizzeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizListViewModel : ViewModel() {
    private val _quizList = MutableStateFlow<List<QuizzeData>>(emptyList())
    val quizList: StateFlow<List<QuizzeData>> = _quizList.asStateFlow()

    private val quizService by lazy { ServicePool.quizService }

    init {
        loadQuizList()
    }

    private fun loadQuizList() {
        viewModelScope.launch {
            runCatching {
                quizService.getQuizList()
            }.onSuccess { response ->
                if (response.success) {
                    _quizList.value = response.result
                } else {
                    println("Error: ${response.message}")
                }
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}