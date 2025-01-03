package com.example.joku_battle.presentation.home

import android.app.Person
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.joku_battle.R
import com.example.joku_battle.data.PersonalInfo

@Composable
fun LeaderBoardItem(personalInfo: PersonalInfo) {
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
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                when (personalInfo.rank) {
                    1 -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_1st_place),
                            contentDescription = "1st_place"
                        )
                    }

                    2 -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_2nd_place),
                            contentDescription = "2nd_place"
                        )
                    }

                    3 -> {
                        Image(
                            //icon 크기가 38*38인데 이후에 수정 필요
                            painter = painterResource(id = R.drawable.ic_3rd_place),
                            contentDescription = "3rd_place"
                        )
                    }

                    else -> {
                        Spacer(modifier = Modifier.size(30.dp))
                    }
                }
                Image(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_leaderboard_profile),
                    contentDescription = "leaderboard_profile"
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = personalInfo.name, fontWeight = FontWeight.Bold)
                    Text(text = personalInfo.department, modifier = Modifier.padding(vertical = 4.dp))
                }
            }

            //점수
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = personalInfo.score.toString()+"점",
                fontWeight = FontWeight.Bold
            )

        }

    }

}


@Preview
@Composable
private fun LeaderBoardItemPreview() {
    val firstPlace = PersonalInfo("John Doe", "건국대학교 컴퓨터 공학부", 1, 100)
    val secondPlace = PersonalInfo("John Doe", "건국대학교 컴퓨터 공학부", 2, 90)
    val thirdPlace = PersonalInfo("John Doe", "건국대학교 컴퓨터 공학부", 3, 80)
    val notInPodium = PersonalInfo("John Doe", "건국대학교 컴퓨터 공학부", 4, 70)
    Column() {
        LeaderBoardItem(firstPlace)
        LeaderBoardItem(secondPlace)
        LeaderBoardItem(thirdPlace)
        LeaderBoardItem(notInPodium)
    }

}