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

@Composable
fun FunQuotesItem(
    rank: Int,
    title: String,
    department: String,
    userName: String,
    recommendCount: Int
) {
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
                    Text(text = title, fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = "$department $userName")
                }
            }
            //끝에 위치할 text
            Text(
                modifier = Modifier
                    .padding(end = 20.dp),
                //세자리 넘어가면 999+ 로 화면에 표시
                text = if (recommendCount > 999) "999+ 픽" else "$recommendCount 픽",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun FunQuotesItemPreview() {
    FunQuotesItem(1, "오늘 해커톤인지 모르고 학교 안감ㅋㅋ", "스마트ICT융합공학과", "김재민", 100)
}