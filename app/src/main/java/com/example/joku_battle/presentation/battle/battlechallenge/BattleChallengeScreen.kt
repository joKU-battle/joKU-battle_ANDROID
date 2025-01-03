package com.example.joku_battle.presentation.battle.battlechallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.joku_battle.R
import com.example.joku_battle.presentation.component.ChangeButton
import com.example.joku_battle.presentation.component.GrayTextField

@Composable
fun BattleChallengeScreen(
    navigateToBattle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: BattleChallengeViewModel = viewModel()
    val battleRanking by viewModel.battleChallengeRanking.collectAsStateWithLifecycle()

    val content by viewModel.content.collectAsStateWithLifecycle()
    val isButtonEnabled = content.isNotBlank()

    Scaffold(
        bottomBar = {
            ChangeButton(
                label = stringResource(R.string.all_submit),
                color = { if (isButtonEnabled) R.color.main_yellow else R.color.gray_200 },
                fontColor = { if (isButtonEnabled) R.color.black else R.color.white }
            ) {
                if (isButtonEnabled) {
                    // 제출 로직
                    viewModel.addBattle()
                    navigateToBattle()
                }
            }
        }
    ) { paddingvalues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingvalues)
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(R.string.battle_challenge_title),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 47.dp)
            )
            Spacer(Modifier.height(7.dp))

            Text(
                text = stringResource(
                    id = R.string.battle_challenge_subtitle
                ),
                fontSize = 12.sp
            )
            Spacer(Modifier.height(27.dp))

            Text(
                text = stringResource(
                    id = R.string.battle_challenge_ranking,
                    battleRanking!!
                ),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = stringResource(
                    id = R.string.battle_challenge_ranking_sub1
                ),
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(
                    id = R.string.battle_challenge_ranking_sub2
                ),
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Spacer(Modifier.height(40.dp))

            Text(
                text = stringResource(R.string.battle_challenge_answer),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(10.dp))
            GrayTextField(
                value = content,
                onValueChange = { viewModel.updateContent(it) },
                placeholder = stringResource(R.string.battle_challenge_answer_textfield),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                shape = 4,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
            )
        }
    }
}