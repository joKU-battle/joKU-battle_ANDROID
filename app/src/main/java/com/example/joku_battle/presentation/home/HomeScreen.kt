package com.example.joku_battle.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){
    val leaderboardList = listOf(
        "1", "2", "3", "4"
    )

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "이번 주 건국대학교 깔깔왕은?",
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "1월 1주차 순위",
            )

            LazyColumn() {

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeScreenPreview(){
    HomeScreen()
}