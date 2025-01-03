package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.request.AddQuizRequestDto
import com.example.joku_battle.api.dto.request.LoginRequestDto
import com.example.joku_battle.api.dto.response.AddQuizResponseDto
import com.example.joku_battle.api.dto.response.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface QuizService {
    @POST("api/quizzes")
    suspend fun addQuiz(
        @Body quizData: AddQuizRequestDto
    ): AddQuizResponseDto
}