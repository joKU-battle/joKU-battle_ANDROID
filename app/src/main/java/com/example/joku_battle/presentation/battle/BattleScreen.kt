package com.example.joku_battle.presentation.battle

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.joku_battle.presentation.navigation.Route

@Composable
fun BattleScreen(
    navigateToBattleChallenge: () -> Unit,
    navigateToAddFunQuotes: () -> Unit
) {
    val viewModel: FunQuotesViewModel = viewModel()
    val funQuotesList by viewModel.funQuotesList.collectAsStateWithLifecycle()

    val month = 1
    val week = 1

    viewModel.fetchJokes(month, week)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 25.dp, top = 47.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        text = "${month}월 ${week}주차 대결",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "이번주 건대 개그맨 선발에 참여해보세요!",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = { navigateToBattleChallenge() },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD600),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(75.dp)
                        .height(45.dp)
                ) {
                    Text(text = "투표", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                itemsIndexed(funQuotesList) { index, joke ->
                    if(index+1 <= 99){
                        FunQuotesItem(joke = joke, rank = index + 1)
                    }
                }
            }
        }


        // Floating Action Button
        FloatingActionButton(
            onClick = { navigateToAddFunQuotes() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
            shape = RoundedCornerShape(50),
            containerColor = Color(0xFFFFD600),
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Item",tint = Color.White)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun BattleScreenPreview() {
    val navController = rememberNavController()
    BattleScreen(
        { navController.navigate(Route.BattleChallenge) },
        //이후에 route 생기면 수정할 예정
        { navController.navigate(Route.QuizAdd) }
    )
}