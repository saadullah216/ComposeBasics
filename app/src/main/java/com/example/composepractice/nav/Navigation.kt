package com.example.composepractice

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.ui.detail.DetailScreen
import com.example.composepractice.ui.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController = navController) }
        composable(
            "detail/{str}",
            arguments = listOf(navArgument("str") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(navController, backStackEntry.arguments?.getString("str"))
        }
    }
}