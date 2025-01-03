package com.example.joku_battle.presentation.my

import androidx.lifecycle.ViewModel
import com.example.joku_battle.presentation.model.MyDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel() {
    private val _myDetail = MutableStateFlow<MyDetail?>(null)
    val myDetail: StateFlow<MyDetail?> = _myDetail.asStateFlow()

    init {
        loadMyDetail()
    }

    private fun loadMyDetail() {
        _myDetail.value = MyDetail(
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231025/1510/P001492081.jpg/dims/resize/F_webp,400",
            name = "김재민",
            department = "스마트ICT융합과",
            month = 1,
            week = 1,
            nickname = "아재개그 대마왕"
        )
    }
}