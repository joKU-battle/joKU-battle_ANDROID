package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.request.AddBattleRequestDto
import com.example.joku_battle.api.dto.response.AddQuizResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface BattleService {
    @POST("api/jokes")
    suspend fun addBattle(
        @Body quizData: AddBattleRequestDto
    ): AddQuizResponseDto
}