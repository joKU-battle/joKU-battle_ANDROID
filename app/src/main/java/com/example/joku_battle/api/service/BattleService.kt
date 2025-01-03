package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.request.AddBattleRequestDto
import com.example.joku_battle.api.dto.response.AddQuizResponseDto
import com.example.joku_battle.api.dto.response.JokesDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BattleService {
    @POST("api/jokes")
    suspend fun addBattle(
        @Body quizData: AddBattleRequestDto
    ): AddQuizResponseDto

    @GET("api/jokes")
    suspend fun getJokes(
        @Query("month") month: Int,
        @Query("week") week: Int
    ): JokesDto
}