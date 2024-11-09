package com.example.bactrack

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object PersonManager {
    val mainUser by mutableStateOf(User("John Doe", 70.0, false, 0.0)) //user defaults to female/sober
}