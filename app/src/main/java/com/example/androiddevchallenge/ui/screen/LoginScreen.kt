/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.firstBaselineToTop
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface,) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier
                .height(304.dp)
                .fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_login_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    "Welcome back",
                    style = MaterialTheme.typography.h2,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .firstBaselineToTop(152.dp)
                        .padding(horizontal = 64.dp)
                        .fillMaxWidth(),
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            LoginTextField("Email address", Icons.Outlined.MailOutline)
            Spacer(modifier = Modifier.height(8.dp))
            LoginTextField("Password", Icons.Filled.Password)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("home")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                )
            ) {
                Text(
                    text = "LOG IN",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onPrimary
                )
            }

        }

    }
}

@Composable
fun LoginTextField(text: String, iconVector: ImageVector) {

    TextField(
        value = "",
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface,
                shape = MaterialTheme.shapes.small
            ),
        textStyle = MaterialTheme.typography.body1,
        leadingIcon = {
            Icon(
                iconVector,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(top = 4.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
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
