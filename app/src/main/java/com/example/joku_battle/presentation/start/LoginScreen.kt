package com.example.joku_battle.presentation.start

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.joku_battle.R
import com.example.joku_battle.presentation.component.ChangeButton
import com.example.joku_battle.presentation.component.IDTextField
import com.example.joku_battle.presentation.component.PasswordTextField

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: LoginViewModel = viewModel()
    val userId by viewModel.userId.collectAsStateWithLifecycle()
    val userPassWord by viewModel.userPassword.collectAsStateWithLifecycle()
    val loginSuccess by viewModel.loginSuccess.collectAsStateWithLifecycle()

    val isButtonEnabled = userId.isNotBlank() && userPassWord.isNotBlank()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
        Spacer(Modifier.height(20.dp))

        IDTextField(
            value = userId,
            onValueChange = { viewModel.updateUserId(it) },
            placeholder = "아이디"
        )
        Spacer(Modifier.height(10.dp))

        PasswordTextField(
            value = userPassWord,
            onValueChange = { viewModel.updateUserPassword(it) },
            placeholder = "비밀번호"
        )

        ChangeButton(
            label = "로그인",
            color = { if (isButtonEnabled) R.color.main_yellow else R.color.gray_200 },
            fontColor = { if (isButtonEnabled) R.color.black else R.color.white }
        ) {
            if (isButtonEnabled) {
                viewModel.postLogin()
            }
        }
    }
    if (loginSuccess) {
        navigateToHome()
    }
}

@Composable
@Preview(showBackground = true)
private fun LoginScreenPreview() {
    LoginScreen({})
}