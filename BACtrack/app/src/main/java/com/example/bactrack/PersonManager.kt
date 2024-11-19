package com.example.bactrack

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
//add log import
import android.util.Log

object PersonManager {
    val mainUser by mutableStateOf(User("John Doe", 70.0, true, 0.0, "08/08/2001", "abc@gmail.com", 8051112222, 8058001234)) //user defaults to female/sober

    //set the user's weight
    fun setWeight(weight: Double) {
        //log our change to the console to test
        Log.d("PersonManager", "Setting weight to $weight")
        mainUser.weight = weight
    }

    //set the user's gender
    fun setGender(gender: Boolean) {
        mainUser.sex = gender
        Log.d("PersonManager", "Setting gender to $gender")
    }
}