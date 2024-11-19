package com.example.bactrack

import com.example.bactrack.SessionManager.currentSession
import com.example.bactrack.PersonManager.mainUser

//use MAINUSER to access weight and gender information

fun calculateBAC(totalAlcoholConsumed: Double, weight: Double, sex: String, time: Double): Double {
    // Constants
    val r = if (sex.equals("female", ignoreCase = true)) 0.55 else 0.68  // Alcohol distribution ratio
    val beta = 0.015  // Alcohol elimination rate

    // Convert weight from kg to grams
    val weightInGrams = weight * 1000 + currentSession.numBeers + mainUser.totalAlcoholConsumed

    // Calculate BAC
    val bac = (totalAlcoholConsumed / (r * weightInGrams)) - (beta * time)

    // Return BAC, ensuring it's not negative
    return if (bac < 0) 0.0 else bac
}


data class User(
    var name: String,
    var weight: Double,
    var sex: Boolean, // "male" or "female"
    var totalAlcoholConsumed: Double,
    var dateOfBirth: String,
    var email: String,
    var phoneNumber: Long,
    var emergencyContactNum: Long

)


