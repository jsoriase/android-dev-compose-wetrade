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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.HomeStaticData
import com.example.androiddevchallenge.firstBaselineToTopAndBottom
import com.example.androiddevchallenge.ui.composables.StockItem
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    "ACCOUNT",
                    style = MaterialTheme.typography.button,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .firstBaselineToTopAndBottom(64.dp, 8.dp)

                )
                Text(
                    "WATCHLIST",
                    style = MaterialTheme.typography.button,
                    color = Color.White.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .firstBaselineToTopAndBottom(64.dp, 8.dp)
                )
                Text(
                    "PROFILE",
                    style = MaterialTheme.typography.button,
                    color = Color.White.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .firstBaselineToTopAndBottom(64.dp, 8.dp)
                )
            }
            Text(
                "Balance",
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .firstBaselineToTopAndBottom(32.dp, 8.dp)
                    .fillMaxWidth()
            )
            Text(
                "$73,589.01",
                style = MaterialTheme.typography.h1,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .firstBaselineToTopAndBottom(48.dp, 24.dp)
                    .fillMaxWidth()
            )
            Text(
                "+412.35 today",
                style = MaterialTheme.typography.subtitle1,
                color = green,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .firstBaselineToTopAndBottom(16.dp, 32.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { },
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
                    text = "TRANSACT",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(modifier = Modifier.padding(start = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(end = 16.dp)) {
                items(HomeStaticData.homeGraphicOptions) { graphicOption ->
                    HomeOutlinedButton(graphicOption.name, graphicOption.expandable)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_home_illos),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(32.dp))
            Surface(color = MaterialTheme.colors.surface) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Positions",
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onSurface,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .firstBaselineToTopAndBottom(40.dp, 24.dp)
                            .fillMaxWidth()
                    )
                    for (stock in HomeStaticData.stocks) {
                        StockItem(stockData = stock)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeOutlinedButton(text: String, expandable: Boolean) {
    OutlinedButton(
        onClick = { },
        border = BorderStroke(1.dp, Color.White),
        shape = RoundedCornerShape(50), // 50% percent
        modifier = Modifier
            .height(40.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            backgroundColor = Color.Transparent
        )
    ) {
        Row {
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            if (expandable) {
                Icon(imageVector = Icons.Filled.ExpandMore, contentDescription = "Expand")
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    val navController = rememberNavController()
    MyTheme {
        HomeScreen(navController)
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}
