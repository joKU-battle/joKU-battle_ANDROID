package com.example.joku_battle.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.api.dto.request.LoginRequestDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _userId = MutableStateFlow<String>("")
    val userId: StateFlow<String> = _userId.asStateFlow()

    private val _userPassword = MutableStateFlow<String>("")
    val userPassword: StateFlow<String> = _userPassword.asStateFlow()

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess.asStateFlow()

    private val userService by lazy { ServicePool.userService }

    fun updateUserId(id: String) {
        _userId.value = id
    }

    fun updateUserPassword(password: String) {
        _userPassword.value = password
    }

    fun postLogin() {
        viewModelScope.launch {
            runCatching {
                userService.postLogin(
                    LoginRequestDto(
                        id = _userId.value,
                        password = _userPassword.value
                    )
                )
            }.onSuccess { response ->
                if (response.success) {
                    _loginSuccess.value = true
                }
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}