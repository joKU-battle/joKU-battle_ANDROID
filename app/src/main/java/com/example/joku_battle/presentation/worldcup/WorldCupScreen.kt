package com.example.joku_battle.presentation.worldcup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R

@Composable
fun WorldCupScreen(){
    var selectedItem by remember { mutableStateOf<String?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Title(
            title = "잼얘 월드컵",
            subTitle = "당신의 잼얘를 선택해주세요!"
        )

        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.img_round_background),
                contentDescription = "라운드 배경",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(2 / 3f)
                    .aspectRatio(2f)
                    .background(color = Color(0x99F3F4F6))
                    .align(Alignment.Center)
            )
            Text(
                text = "8강 1/4",
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Battle(
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun Title(
    title: String,
    subTitle: String
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 24.dp)
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight(700)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subTitle
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun Battle(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp)
        ){
            item {
                Text(
                    text = "샬라살라"
                )
            }
        }

        Text(
            text = "VS",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFAC929),
            modifier = Modifier.padding(vertical = 4.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp)
        ){
            item {
                Text(
                    text = "샬라살라"
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
private fun WorldCupScreenPreview(){
    WorldCupScreen()
}