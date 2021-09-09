package com.example.composepractice.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, string: String?) {

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
        string?.let { Text(text = "Selected Text is :: $it" ,  color = Color.Black , fontSize = 30.sp , fontWeight = FontWeight.Bold)  }
    }

}