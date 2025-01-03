package com.example.joku_battle.api.service

import com.example.joku_battle.api.dto.request.LoginRequestDto
import com.example.joku_battle.api.dto.response.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("api/users/login")
    suspend fun postLogin(
        @Body userData: LoginRequestDto
    ): LoginResponseDto
}