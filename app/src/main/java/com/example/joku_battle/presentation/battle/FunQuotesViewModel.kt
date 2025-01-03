package com.example.joku_battle.presentation.battle

import androidx.lifecycle.ViewModel
import com.example.joku_battle.presentation.model.QuizChallengeDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FunQuotesViewModel : ViewModel(){
    private val _funQuotesList = MutableStateFlow<List<FunQuotes>>(emptyList())
    val funQuotesList: StateFlow<List<FunQuotes>> = _funQuotesList

    init {
        loadFunQuotesList()
    }

    private fun loadFunQuotesList(){
        _funQuotesList.value = listOf(
            FunQuotes(1, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 1000),
            FunQuotes(2, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 990),
            FunQuotes(3, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 800),
            FunQuotes(4, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 70),
            FunQuotes(5, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 60),
            FunQuotes(6, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(7, "오늘 해커톤인지 모르고 학교 안감ㅋ", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(8, "오늘 해커톤인지 모르고 학교 안감", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(9, "오늘 해커톤인지 모르고 ", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(10, "오늘 해커톤인지 ", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(99, "오늘 해커톤인지 ", "스마트ICT융합공학과", "김재민", 50),
            FunQuotes(100, "오늘 해커톤인지 ", "스마트ICT융합공학과", "김재민", 50),
        )
    }

}


data class FunQuotes(
    val rank: Int,
    val title: String,
    val department: String,
    val userName: String,
    val recommendCount: Int
)
