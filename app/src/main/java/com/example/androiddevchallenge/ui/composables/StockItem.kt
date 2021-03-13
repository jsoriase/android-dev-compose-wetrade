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
package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.HomeStaticData
import com.example.androiddevchallenge.firstBaselineToTop
import com.example.androiddevchallenge.firstBaselineToTopAndBottom
import com.example.androiddevchallenge.model.StockData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun StockItem(stockData: StockData) {
    Box(modifier = Modifier.height(56.dp).fillMaxWidth()) {
        Divider(
            color = MaterialTheme.colors.onSurface,
            thickness = 1.dp,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = stockData.value,
                style = MaterialTheme.typography.body1,
                color = green,
                textAlign = TextAlign.Center,
                modifier = Modifier.firstBaselineToTop(24.dp)

            )
            val color = if (stockData.difference >= 0) green else red
            Text(
                text = "${stockData.difference}%",
                style = MaterialTheme.typography.body1,
                color = color,
                textAlign = TextAlign.Center,
                modifier = Modifier.firstBaselineToTopAndBottom(16.dp, 16.dp)
            )
        }
        Column(modifier = Modifier.padding(start = 80.dp)) {
            Text(
                text = stockData.abreviation,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.firstBaselineToTop(24.dp)

            )
            Text(
                text = stockData.name,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.firstBaselineToTopAndBottom(16.dp, 16.dp)
            )
        }
        Image(
            painter = painterResource(id = stockData.chart),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterEnd)
                .padding(vertical = 16.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Preview("Light Theme")
@Composable
fun StockItemLightPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.surface) {
            StockItem(HomeStaticData.stocks[0])
        }
    }
}

@Preview("Dark Theme")
@Composable
fun StockItemDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.surface) {
            StockItem(HomeStaticData.stocks[0])
        }
    }
}
