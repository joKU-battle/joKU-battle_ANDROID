package com.example.joku_battle.presentation.battle

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
import com.example.joku_battle.api.dto.response.Joke

@Composable
fun FunQuotesItem(joke: Joke, rank: Int) {
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
            Row(
                modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(rank.toString(), fontSize = 30.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(40.dp))

                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = joke.content, fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = "${joke.userDepartment} ${joke.userName}",
                        fontSize = 14.sp
                        )
                }
            }
            //끝에 위치할 text
            Text(
                modifier = Modifier
                    .padding(end = 20.dp),
                //세자리 넘어가면 999+ 로 화면에 표시
                text = if (joke.pickedCount> 999) "999+ 픽" else "${joke.pickedCount}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun FunQuotesItemPreview() {
    val joke = Joke(1,"asd","2025-01-03T20:48:15.228276","asd","asd",1)
    FunQuotesItem(joke = joke, 1)
}