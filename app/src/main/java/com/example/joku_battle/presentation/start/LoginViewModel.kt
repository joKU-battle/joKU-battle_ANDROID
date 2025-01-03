package com.example.joku_battle.presentation.start

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _userId = MutableStateFlow<String>("")
    val userId: StateFlow<String> = _userId.asStateFlow()

    private val _userPassword = MutableStateFlow<String>("")
    val userPassword: StateFlow<String> = _userPassword.asStateFlow()

    fun updateUserId(id: String) {
        _userId.value = id
    }

    fun updateUserPassword(password: String) {
        _userPassword.value = password
    }


}