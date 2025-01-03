package com.example.joku_battle.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.joku_battle.presentation.battle.BattleScreen
import com.example.joku_battle.presentation.battle.battlechallenge.BattleChallengeScreen
import com.example.joku_battle.presentation.home.HomeScreen
import com.example.joku_battle.presentation.my.MyScreen
import com.example.joku_battle.presentation.quiz.quizchallenge.QuizChallengeScreen
import com.example.joku_battle.presentation.quiz.QuizScreen
import com.example.joku_battle.presentation.quiz.quizadd.QuizAddScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    var selectedMainBottomTab by remember { mutableStateOf(BottomNavigationItem.HOME) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute by remember { derivedStateOf { navBackStackEntry?.destination?.route } }


    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),
        bottomBar = {
            if (
                currentRoute in listOf(
                    Route.Home::class.qualifiedName,
                    Route.Quiz::class.qualifiedName,
                    Route.Battle::class.qualifiedName,
                    Route.My::class.qualifiedName
                )
            ) {
                BottomNavigation(
                    selectedItem = selectedMainBottomTab,
                    onItemSelected = { selectedMainBottomTab = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) {
        Surface(color = Color.White) {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = Route.Home
            ) {
                composable<Route.Home> {
                    HomeScreen()
                }

                composable<Route.Quiz> {
                    QuizScreen(
                        { navController.navigate(Route.QuizAdd) },
                        { navController.navigate(Route.QuizChallenge) }
                    )
                }

                composable<Route.QuizChallenge> {
                    QuizChallengeScreen()
                }

                composable<Route.QuizAdd> {
                    QuizAddScreen()
                }

                composable<Route.Battle> {
                    BattleScreen({ navController.navigate(Route.BattleChallenge) },
                        //이후에 잼얘 추가 화면으로 수정할 예정
                        { navController.navigate(Route.QuizAdd) }
                    )
                }

                composable<Route.BattleChallenge> {
                    BattleChallengeScreen()
                }

                composable<Route.My> {
                    MyScreen()
                }
            }
        }
    }

    LaunchedEffect(key1 = selectedMainBottomTab) {  // 하단 탭 선택에 의한 라우팅 처리
        val targetRoute = when (selectedMainBottomTab) {
            BottomNavigationItem.HOME -> Route.Home::class.qualifiedName
            BottomNavigationItem.QUIZ -> Route.Quiz::class.qualifiedName
            BottomNavigationItem.BATTLE -> Route.Battle::class.qualifiedName
            BottomNavigationItem.MY -> Route.My::class.qualifiedName
        } ?: ""

        navController.navigate(targetRoute) {
            popUpTo(Route.Home) {
                saveState = true
                inclusive = false
            }
            launchSingleTop = true
        }
    }

    LaunchedEffect(key1 = currentRoute) {   // 뒤로가기에 의한 하단 탭 변경 처리
        selectedMainBottomTab = when (currentRoute) {
            Route.Home::class.qualifiedName -> BottomNavigationItem.HOME
            Route.Quiz::class.qualifiedName -> BottomNavigationItem.QUIZ
            Route.Battle::class.qualifiedName -> BottomNavigationItem.BATTLE
            Route.My::class.qualifiedName -> BottomNavigationItem.MY
            else -> selectedMainBottomTab
        }
    }
}