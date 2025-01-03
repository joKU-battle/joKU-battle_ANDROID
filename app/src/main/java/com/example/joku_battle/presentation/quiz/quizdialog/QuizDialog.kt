package com.example.joku_battle.presentation.quiz.quizdialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R

@Composable
fun QuizDialog(isCorrect: Boolean, onDismiss: () -> Unit, onRecommend: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            if (isCorrect) {
                Text(
                    "맞았습니다!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    color = Color(0xFFFFD600)
                )
            } else {
                Text(
                    "틀렸습니다!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    color = Color.Red
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("머리 빡빡 깎은 중이 떠나가면?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("정답은 ..!", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Box(modifier = Modifier.fillMaxWidth()) {
                    if (isCorrect) {
                        Image(
                            painter = painterResource(R.drawable.img_dialog_correct),
                            contentDescription = "img_for_correct_answer"
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.img_dialog_wrong),
                            contentDescription = "img_for_correct_answer"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .height(100.dp)
                            .align(Alignment.Center)
                            .background(Color.White.copy(alpha = 0.6f))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("민중가요", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                }

            }
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { onDismiss() },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(120.dp)
                        .height(45.dp)
                ) {
                    Text("나가기", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onRecommend() },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD600),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(120.dp)
                        .height(45.dp)
                ) {
                    Text("추천하기", fontSize = 16.sp)
                }
            }
        },
        dismissButton = {}
    )
}

@Preview
@Composable
private fun QuizDialogPreview() {
//    QuizDialog(true, {}, {})
    QuizDialog(false, {}, {})
}