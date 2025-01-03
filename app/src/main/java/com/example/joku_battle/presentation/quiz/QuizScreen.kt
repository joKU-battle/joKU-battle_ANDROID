package com.example.joku_battle.presentation.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.joku_battle.presentation.navigation.Route

@Composable
fun QuizScreen(
    ToQuizChallenge: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "MyScreen",
            modifier = Modifier.clickable {
                ToQuizChallenge()
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun QuizScreenPreview() {
}