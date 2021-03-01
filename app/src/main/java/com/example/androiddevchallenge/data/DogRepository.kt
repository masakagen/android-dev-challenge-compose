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

object DogRepository {
    private val dogs = listOf<Dog>(
        Dog(DogId("1"), R.drawable.dog1, "Ace", 5),
        Dog(DogId("2"), R.drawable.dog2, "Apollo", 2),
        Dog(DogId("3"), R.drawable.dog3, "Lilly", 3),
        Dog(DogId("4"), R.drawable.dog4, "Emma", 4),
        Dog(DogId("5"), R.drawable.dog5, "Maggie", 5),
        Dog(DogId("6"), R.drawable.dog6, "Chico", 3),
        Dog(DogId("7"), R.drawable.dog7, "Coco", 2),
        Dog(DogId("8"), R.drawable.dog8, "Sadie", 5),
        Dog(DogId("9"), R.drawable.dog9, "Milo", 3),
        Dog(DogId("10"), R.drawable.dog10, "Daisy", 2),
        Dog(DogId("11"), R.drawable.dog11, "Luke", 4),
        Dog(DogId("12"), R.drawable.dog12, "Lucy", 2),
        Dog(DogId("13"), R.drawable.dog13, "Jax", 1),
    )

    fun finds(): List<Dog> {
        return dogs
    }

    fun find(id: DogId): Dog {
        return dogs.single { dog ->
            dog.id == id
        }
    }
}
