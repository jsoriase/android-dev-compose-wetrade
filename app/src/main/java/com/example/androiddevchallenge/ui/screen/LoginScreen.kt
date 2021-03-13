package com.example.androiddevchallenge.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavController) {

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenLightPreview() {
    val navController = rememberNavController()
    MyTheme {
        LoginScreen(navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}