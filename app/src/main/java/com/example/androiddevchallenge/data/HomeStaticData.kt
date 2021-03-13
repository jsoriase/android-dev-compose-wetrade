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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.GraphicOption
import com.example.androiddevchallenge.model.StockData

class HomeStaticData {

    companion object {

        val homeGraphicOptions = arrayListOf(
            GraphicOption("Week", true),
            GraphicOption("ETFs", false),
            GraphicOption("Stocks", false),
            GraphicOption("Funds", false),
            GraphicOption("Others", false),
            GraphicOption("Anothers", false),
        )

        val stocks = arrayListOf(
            StockData("$7,918", -0.54, "ALK", "Alaska Air Group, Inc.", R.drawable.ic_home_alk),
            StockData("$1,293", 4.18, "BA", "Boeing Co.", R.drawable.ic_home_ba),
            StockData("$893.50", -0.54, "DAL", "Delta Airlines Inc.", R.drawable.ic_home_dal),
            StockData("$12,301", -2.51, "EXPE", "Expedia Group Inc.", R.drawable.ic_home_exp),
            StockData("$12,301", -1.38, "EADSY", "Airbus SE", R.drawable.ic_home_eadsy),
            StockData("$8,521", 1.56, "JBLU", "Jetblue Airways Corp.", R.drawable.ic_home_jblu),
            StockData("$521", 2.75, "MAR", "Marriot International Inc.", R.drawable.ic_home_mar),
            StockData("$5,481", 0.14, "CCL", "Carnival Corp", R.drawable.ic_home_ccl),
            StockData("$9,184", 1.69, "RCL", "Royal Caribbean Cruises", R.drawable.ic_home_rcl),
            StockData("$654", 3.23, "TRVL", "Travelocity Inc.", R.drawable.ic_home_trvl),

        )
    }
}
