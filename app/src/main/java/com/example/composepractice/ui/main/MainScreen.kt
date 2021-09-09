package com.example.composepractice.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    val data by remember {
        viewModel.data
    }
    val error by remember {
        viewModel.loadError
    }
    val isLoading by remember {
        viewModel.isLoading
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colors.primary)
                }
            }
            error.isNotBlank() -> {
                RetrySection(error = error) {
                    viewModel.loadData()
                }
            }
            else -> {
                DataList(data = data , navController = navController)
            }
        }
    }
}

@Composable
fun DataList(data: List<String> ,navController: NavController) {
    LazyColumn {
        items(data.size) { index ->
            DataRow(str = data.get(index = index)) {
                navController.navigate("detail/$it")
            }
        }
    }
}

@Composable
fun SnackBar() {
    Snackbar(modifier = Modifier.padding(4.dp)) {
        Text(text = "This is a basic snackbar")
    }
}

@Composable
fun DataRow(
    str: String,
    onClick: (str: String) -> Unit
) {
    Box(
        Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick(str) },
            shape = RoundedCornerShape(15),
            elevation = 10.dp,

            ) {
            Text(
                text = str,
                textAlign = TextAlign.Justify,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(error, color = Color.Red, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {

    }
}