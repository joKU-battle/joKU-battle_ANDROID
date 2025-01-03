package com.example.joku_battle.presentation.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.joku_battle.R
import com.example.joku_battle.presentation.model.QuizChallengeDetail

@Composable
fun QuizItem(quizInfo: QuizChallengeDetail, navigateToQuizChallenge: () -> Unit) {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 1.dp,
        color = Color.Gray
    )
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp)
                .clickable { navigateToQuizChallenge() },

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row{
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(35.dp),
                    painter = painterResource(id = R.drawable.img_quiz_emoji),
                    contentDescription = "leaderboard_profile"
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = quizInfo.title, fontWeight = FontWeight.Bold)
                    Text(text = quizInfo.department + " " + quizInfo.userName)
                }
            }
            //끝에 위치할 text
            Text(
                modifier = Modifier
                    .padding(end = 24.dp),
                text = "추천 "+quizInfo.recommendCount,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Preview
@Composable
fun QuizItemPreview() {
    val quizInfo = QuizChallengeDetail("title", "department", "userName", 1, 1, 1, 38)
    QuizItem(quizInfo, { })
}