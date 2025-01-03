package com.example.joku_battle.presentation.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R
import com.example.joku_battle.api.dto.response.QuizzeData
import com.example.joku_battle.presentation.model.QuizChallengeDetail

@Composable
fun QuizItem(quizInfo: QuizzeData, navigateToQuizChallenge: (Int) -> Unit) {
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
                .clickable { navigateToQuizChallenge(quizInfo.quizId) },

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(35.dp),
                    painter = painterResource(id = R.drawable.img_quiz_emoji),
                    contentDescription = "leaderboard_profile"
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = quizInfo.question, fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp
                    )
                    Text(
                        text = quizInfo.userDepartment + " " + quizInfo.userName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(end = 20.dp),
                text = if (quizInfo.recommendation > 99) "99+ 추천" else quizInfo.recommendation.toString() + " 추천",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

@Preview
@Composable
fun QuizItemPreview() {
}