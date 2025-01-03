package com.example.joku_battle.presentation.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.presentation.model.QuizChallengeDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizChallengeViewModel : ViewModel() {
    private val _quizChallengeDetail = MutableStateFlow(
        QuizChallengeDetail(
            title = "로딩 중...",
            department = "로딩 중...",
            userName = "로딩 중...",
            ranking = 0,
            rightCount = 0,
            wrongCount = 0,
            recommendCount = 0
        )
    )
    val quizChallengeDetail: StateFlow<QuizChallengeDetail?> = _quizChallengeDetail.asStateFlow()

    private val quizService by lazy { ServicePool.quizService }

    fun loadQuizChallengeDetail(quizId: Int) {
        viewModelScope.launch {
            runCatching {
                quizService.getQuiz(quizId)
            }.onSuccess { response ->
                if (response.success) {
                    val data = response.result
                    _quizChallengeDetail.value = QuizChallengeDetail(
                        title = data.question,
                        department = data.userDepartment,
                        userName = data.userName,
                        ranking = 1,
                        rightCount = data.correct,
                        wrongCount = data.wrong,
                        recommendCount = data.recommendation
                    )
                } else {
                    println("Error: ${response.message}")
                }
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}