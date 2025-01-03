package com.example.joku_battle.presentation.worldcup

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R

@Composable
fun WorldCupScreen(){
    var selectedItem by remember { mutableStateOf<String?>(null) }
    var itemCoordinates by remember { mutableStateOf<Pair<Float, Float>?>(null) }
    var itemSize by remember { mutableStateOf<Pair<Float, Float>?>(null) }

    var visible by remember {
        mutableStateOf(false)
    }

    val participantList = mutableListOf(
        "1","2","3","4","5","6","7","8"
    )

    Log.d("zz", (itemCoordinates?.second?:0f).toString())

    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (selectedItem == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Title(
                    title = "잼얘 월드컵",
                    subTitle = "당신의 잼얘를 선택해주세요!"
                )

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
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
                    modifier = Modifier.weight(1f),
                    firstParticipant = participantList[0],
                    secondParticipant = participantList[1],
                    selectedItem = selectedItem,
                    onSelectedItemChanged = { item, coordinates, size ->
                        selectedItem = item
                        itemCoordinates = coordinates
                        itemSize = size
                    }
                )
            }
        } else {

            val (x, y) = itemCoordinates ?: Pair(0f, 0f)
            val (width, height) = itemSize ?: Pair(0f, 0f)
            val widthInDp = with(density) { width.toDp() }
            val heightInDp = with(density) { height.toDp() }

            val animatedY by animateFloatAsState(
                targetValue = if (visible) 200f else itemCoordinates!!.second, // 'visible'이 true일 때 200으로 애니메이션
                animationSpec = tween(durationMillis = 1000)
            )

            visible = true

            Box(
                modifier = Modifier
                    .graphicsLayer(
                        translationX = x,
                        translationY = animatedY
                    )
                    .size(widthInDp, heightInDp)
                    .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                    .clickable {
                        // 다시 선택 초기화
                        selectedItem = null
                    }
                    .padding(15.dp)
            ) {
                Text(
                    text = (selectedItem + width.toString() + height.toString() + x.toString() + y.toString()) ?: ""
                )
            }
        }
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
    modifier: Modifier = Modifier,
    firstParticipant: String,
    secondParticipant: String,
    selectedItem: String?,
    onSelectedItemChanged: (String, Pair<Float, Float>, Pair<Float, Float>) -> Unit
){
    var positionA = Offset(0F, 0F)
    var sizeA = IntSize(0,0)
    var positionB = Offset(0F, 0F)
    var sizeB = IntSize(0,0)

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
                .onGloballyPositioned { coordinates ->
                    positionA = coordinates.positionInRoot()
                    sizeA = coordinates.size
                }
                .clickable {
                    onSelectedItemChanged(
                        firstParticipant,
                        Pair(positionA.x, positionA.y),
                        Pair(sizeA.width.toFloat(), sizeA.height.toFloat())
                    )
                }
                .padding(15.dp)
        ){
            item {
                Text(
                    text = firstParticipant
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
                .onGloballyPositioned { coordinates ->
                    positionB = coordinates.positionInRoot()
                    sizeB = coordinates.size
                }
                .clickable {
                    onSelectedItemChanged(
                        firstParticipant,
                        Pair(positionB.x, positionB.y),
                        Pair(sizeB.width.toFloat(), sizeB.height.toFloat())
                    )
                }
                .padding(15.dp)
        ){
            item {
                Text(
                    text = secondParticipant
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