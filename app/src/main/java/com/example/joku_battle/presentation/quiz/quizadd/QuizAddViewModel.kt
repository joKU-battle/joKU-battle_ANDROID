package com.example.joku_battle.presentation.quiz.quizadd

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.TokenManager
import com.example.joku_battle.api.dto.request.AddQuizRequestDto
import com.example.joku_battle.api.dto.request.LoginRequestDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizAddViewModel : ViewModel() {
    private val quizService by lazy { ServicePool.quizService }

    private val _question = MutableStateFlow("")
    val question: StateFlow<String> = _question.asStateFlow()

    private val _answer = MutableStateFlow("")
    val answer: StateFlow<String> = _answer.asStateFlow()

    fun updateQuestion(question: String) {
        _question.value = question
    }

    fun updateAnswer(answer: String) {
        _answer.value = answer
    }

    fun addQuiz() {
        viewModelScope.launch {
            runCatching {
                quizService.addQuiz(
                    AddQuizRequestDto(
                        question = question.value,
                        answer = answer.value
                    )
                )
            }.onSuccess { response ->
                Log.d("zz","성공")
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}