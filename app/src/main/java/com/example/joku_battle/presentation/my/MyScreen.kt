package com.example.joku_battle.presentation.my

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.joku_battle.R

@Composable
fun MyScreen(
    navigateToLogin: () -> Unit
) {
    val viewModel: MyViewModel = viewModel()
    val myData by viewModel.myDetail.collectAsStateWithLifecycle()

    if (myData == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "로딩 중...",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(R.string.my_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                AsyncImage(
                    model = myData!!.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(36.dp))
                )
                Spacer(Modifier.width(20.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = myData!!.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = stringResource(
                            R.string.my_info,
                            myData!!.department
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(
                        color = colorResource(R.color.main_yellow),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.my_latest_nickname,
                        myData!!.month,
                        myData!!.week,
                        myData!!.nickname
                    ),
                    color = colorResource(R.color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(40.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Divider(
                    color = colorResource(R.color.gray_300)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.my_nickname_title),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_nicknames),
                        fontSize = 12.sp
                    )
                }

                Divider(
                    color = colorResource(R.color.gray_300)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.my_quiz_title),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_quizs),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_right_quizs),
                        fontSize = 12.sp
                    )
                }

                Divider(
                    color = colorResource(R.color.gray_300)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.my_battle_title),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_battles),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_battle_history),
                        fontSize = 12.sp
                    )
                }

                Divider(
                    color = colorResource(R.color.gray_300)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.my_account_title),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_account_name_change),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_account_department_change),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_account_password_change),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = stringResource(R.string.my_logout),
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable { navigateToLogin() }
                    )
                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun MyScreenPreview() {
    MyScreen() {}
}