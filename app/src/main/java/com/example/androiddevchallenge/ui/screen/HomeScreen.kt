package com.example.androiddevchallenge.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(navController: NavController) {

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    val navController = rememberNavController()
    MyTheme {
        WelcomeScreen(navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        val navController = rememberNavController()
        WelcomeScreen(navController)
    }
}