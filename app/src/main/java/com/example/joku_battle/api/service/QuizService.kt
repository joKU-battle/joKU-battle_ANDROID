package com.example.joku_battle.api.service

import retrofit2.http.GET

interface QuizService {
    @GET("api/quizzes")
    suspend fun getQuizList(

    )
}