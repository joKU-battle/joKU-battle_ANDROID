package com.example.joku_battle.presentation.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joku_battle.api.ServicePool
import com.example.joku_battle.presentation.model.MyDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _myDetail = MutableStateFlow(
        MyDetail(
            imageUrl = "",
            name = "로딩 중...",
            department = "로딩 중...",
            month = 0,
            week = 0,
            nickname = "로딩 중..."
        )
    )
    val myDetail: StateFlow<MyDetail?> = _myDetail.asStateFlow()

    private val userService by lazy { ServicePool.userService }

    init {
        loadMyDetail()
    }

    private fun loadMyDetail() {
        viewModelScope.launch {
            runCatching {
                userService.getMyPage()
            }.onSuccess { response ->
                if (response.success) {
                    val data = response.result
                    _myDetail.value = MyDetail(
                        imageUrl = data.imageUrl,
                        name = data.name,
                        department = data.department,
                        month = data.title.month,
                        week = data.title.week,
                        nickname = data.title.name
                    )
                } else {
                    println("Error: ${response.message}")
                }
            }.onFailure { exception ->
                exception.printStackTrace()
            }
        }
    }
}