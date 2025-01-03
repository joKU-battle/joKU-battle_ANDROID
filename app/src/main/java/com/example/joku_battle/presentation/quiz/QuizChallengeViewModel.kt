package com.example.joku_battle.presentation.quiz

import androidx.lifecycle.ViewModel
import com.example.joku_battle.presentation.model.QuizChallegeDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizChallengeViewModel : ViewModel() {
    private val _quizChallengeDetail = MutableStateFlow<QuizChallegeDetail?>(null)
    val quizChallegeDetail: StateFlow<QuizChallegeDetail?> = _quizChallengeDetail.asStateFlow()

    init {
        loadQuizChallengeDetail()
    }

    private fun loadQuizChallengeDetail() {
        _quizChallengeDetail.value = QuizChallegeDetail(
            title = "머리 빡빡 깎은 중이 떠나가면?",
            department = "스마트ICT융합공학과",
            userName = "김재민",
            ranking = 1,
            rightCount = 24,
            wrongCount = 38,
            recommendCount = 39
        )
    }
}