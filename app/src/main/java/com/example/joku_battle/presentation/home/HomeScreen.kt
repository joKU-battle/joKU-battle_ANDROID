package com.example.joku_battle.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R
import com.example.joku_battle.data.PersonalInfo

@Composable
fun HomeScreen(){
    val dummyLeaderboardList = listOf(
        PersonalInfo("John Doe", "건국대학교 컴퓨터공학부", 1, 100),
        PersonalInfo("John Doe", "건국대학교 컴퓨터공학부", 2, 90),
        PersonalInfo("John Doe", "건국대학교 있는지없는지모르겠는학과명", 3, 80),
        PersonalInfo("아주아주아주아주아주아주아주아주긴이름", "건국대학교 컴퓨터 공학부", 4, 70),
        PersonalInfo("John Doe","건국대학교 컴퓨터공학부",5,60)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(modifier = Modifier
            .size(100.dp)
            .padding(top = 19.dp, end = 14.dp)
            .align(Alignment.TopEnd),
            painter = painterResource(id = R.drawable.img_home_konkuk), contentDescription = "konkuk_logo_home")

        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
        ){
            Column(modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, top = 47.dp)){
                Text(
                    text = "이번 주 건국대학교 깔깔왕은?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "1월 1주차 순위",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }

            LazyColumn(modifier = Modifier.fillMaxWidth().padding(top = 30.dp)) {
                items(dummyLeaderboardList){ personalInfo ->
                    LeaderBoardItem(personalInfo)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeScreenPreview(){
    HomeScreen()
}