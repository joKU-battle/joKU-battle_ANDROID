package com.example.joku_battle.presentation.quiz

import androidx.lifecycle.ViewModel
import com.example.joku_battle.presentation.model.QuizChallengeDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizListViewModel : ViewModel() {
    private val _quizList = MutableStateFlow<List<QuizChallengeDetail>>(emptyList())
    val quizList: StateFlow<List<QuizChallengeDetail>> = _quizList

    init {
        loadQuizChallengeDetail()
    }

    private fun loadQuizChallengeDetail() {
        _quizList.value = listOf(
            QuizChallengeDetail(
                title = "이 편지는 영국에서 최초로 시작되어 일년에 한바퀴를 돌면서 받는 사람에게 행운을 주었고 지금은 당신에게로 옮겨진 이 편지는 4일 안에 당신 곁을 떠나야 합니다. 이 편지를 포함해서 7통을 행운이 필요한 사람에게 보내 주셔야 합니다. 복사를 해도 좋습니다. 혹 미신이라 하실지 모르지만 사실입니다.",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "아주긴이름을가진사람",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 999
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
            QuizChallengeDetail(
                title = "머리 빡빡 깎은 중이 떠나가면?",
                department = "스마트ICT융합공학과",
                userName = "김재민",
                ranking = 1,
                rightCount = 24,
                wrongCount = 38,
                recommendCount = 39
            ),
        )
    }
}