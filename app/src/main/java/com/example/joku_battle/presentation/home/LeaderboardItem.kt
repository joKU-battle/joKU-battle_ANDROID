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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.joku_battle.R
import com.example.joku_battle.api.dto.response.RankingUser
import com.example.joku_battle.data.PersonalInfo

@Composable
fun LeaderBoardItem(personalInfo: RankingUser, rank: Int) {
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
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                when (rank) {
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
                if(personalInfo.image.isNullOrEmpty()){
                    Image(
                        modifier = Modifier.padding(start = 10.dp),
                        painter = painterResource(id = R.drawable.ic_leaderboard_profile),
                        contentDescription = "leaderboard_profile"
                    )
                }else{
                    AsyncImage(
                        model = personalInfo.image,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(38.dp)
                            .clip(RoundedCornerShape(36.dp)),
                        contentDescription = "leaderboard_profile",
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = personalInfo.name, fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp
                    )
                    Text(
                        text = personalInfo.department,
                        modifier = Modifier.padding(vertical = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp
                    )
                }
            }

            //점수
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = personalInfo.score.toString() + "점",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        }

    }

}


@Preview
@Composable
private fun LeaderBoardItemPreview() {
    val firstPlace = RankingUser("John Doe", "건국대학교 컴퓨터공학부", 10000,"")
    val secondPlace = RankingUser("John Doe", "건국대학교 컴퓨터공학부", 90,"")
    val thirdPlace = RankingUser("John Doe", "건국대학교 있는지없는지모르겠는학과명", 80,"")
    val notInPodium = RankingUser("아주아주아주아주아주아주아주아주긴이름", "건국대학교 컴퓨터 공학부", 70,"")
    Column() {
        LeaderBoardItem(firstPlace,1)
        LeaderBoardItem(secondPlace,2)
        LeaderBoardItem(thirdPlace,3)
        LeaderBoardItem(notInPodium,4)
    }
}