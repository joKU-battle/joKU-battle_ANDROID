package com.example.joku_battle.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joku_battle.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    toHome: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        toHome()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_home_konkuk),
            contentDescription = null,
            modifier = Modifier
                .padding(30.dp)
                .size(150.dp)
        )

        Text(
            text = stringResource(R.string.splash_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(
            text = stringResource(R.string.login_subtitle),
            fontSize = 12.sp
        )



    }

}

@Composable
@Preview(showBackground = true)
private fun SplashScreenPreview() {
}