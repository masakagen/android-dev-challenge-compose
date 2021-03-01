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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.DogRepository
import com.example.androiddevchallenge.ui.detail.DogDetail
import com.example.androiddevchallenge.ui.list.DogList

// Reference: Owl
object MainDestinations {
    const val LIST_ROUTE = "list"
    const val DETAIL_ROUTE = "detail"
    const val DETAIL_DOG_ID_KEY = "dogId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.LIST_ROUTE) {
    val navController = rememberNavController()
    val actions = NavActions(navController)
    NavHost(navController, startDestination = startDestination) {
        composable(
            MainDestinations.LIST_ROUTE
        ) {
            DogList(DogRepository.finds(), actions.selectDog)
        }
        composable(
            "${MainDestinations.DETAIL_ROUTE}/{${MainDestinations.DETAIL_DOG_ID_KEY}}",
            arguments = listOf(navArgument(MainDestinations.DETAIL_DOG_ID_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val dogId = arguments.getString(MainDestinations.DETAIL_DOG_ID_KEY, "")
            DogDetail(dogId, actions.upPress)
        }
    }
}

class NavActions(navController: NavController) {
    val selectDog: (String) -> Unit = { dogId ->
        navController.navigate(
            "${MainDestinations.DETAIL_ROUTE}/$dogId"
        )
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
