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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.DogId
import com.example.androiddevchallenge.data.DogRepository

@Composable
fun DogDetail(dogId: String, onPressUp: () -> Unit) {
    val dog = remember(dogId) { DogRepository.find(DogId(dogId)) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = dog.name)
                },
                navigationIcon = {
                    IconButton(onClick = { onPressUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            DogDetailImage(dog)
            DogDetailArticle(dog)
        }
    }
}

@Composable
fun DogDetailImage(dog: Dog) {
    Image(
        painter = painterResource(id = dog.image),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
    )
}

@Composable
fun DogDetailArticle(dog: Dog) {
    Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        DogDetailName(dog)
        DogDetailAge(dog)
    }
}

@Composable
fun DogDetailName(dog: Dog) {
    Text("Name: ${dog.name}")
}

@Composable
fun DogDetailAge(dog: Dog) {
    Text("Age: ${dog.age}")
}
