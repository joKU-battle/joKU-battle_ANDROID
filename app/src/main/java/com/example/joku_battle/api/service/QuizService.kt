package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.request.AddQuizRequestDto
import com.example.joku_battle.api.dto.response.AddQuizResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface QuizService {
    @POST("api/quizzes")
    suspend fun addQuiz(
        @Body quizData: AddQuizRequestDto
    ): AddQuizResponseDto

    @GET("api/quizzes")
    suspend fun getQuizList(

    )
}