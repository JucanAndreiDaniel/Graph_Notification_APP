/*
 * Copyright 2018 Google LLC
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

package com.scfnotification.notifyme.utilities

import com.scfnotification.notifyme.data.entities.CryptoCoin

val testPlants = arrayListOf(
    CryptoCoin("bitcoin", "btc", "Bitcoin", "", ""),
    CryptoCoin("dogecoin", "doge", "Dogecoin", "", ""),
    CryptoCoin("3", "C", "Description C", "", "")
)
val testPlant = testPlants[0]
