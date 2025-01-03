package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.response.RankingResponseDto
import retrofit2.http.GET

interface RankingService {
    @GET("api/users/ranking")
    suspend fun getRanking(): RankingResponseDto
}