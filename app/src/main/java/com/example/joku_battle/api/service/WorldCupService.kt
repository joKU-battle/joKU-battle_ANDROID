package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.response.GetParticipantsResponseDto
import retrofit2.http.GET

interface WorldCupService {
    @GET("api/jokes/worldcup")
    suspend fun getParticipants(): GetParticipantsResponseDto
}