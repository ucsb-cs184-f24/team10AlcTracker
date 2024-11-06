package com.example.bactrack

fun calculateBAC(totalAlcoholConsumed: Double, weight: Double, sex: String, time: Double): Double {
    // Constants
    val r = if (sex.equals("female", ignoreCase = true)) 0.55 else 0.68  // Alcohol distribution ratio
    val beta = 0.015  // Alcohol elimination rate

    // Convert weight from kg to grams
    val weightInGrams = weight * 1000

    // Calculate BAC
    val bac = (totalAlcoholConsumed / (r * weightInGrams)) - (beta * time)

    // Return BAC, ensuring it's not negative
    return if (bac < 0) 0.0 else bac
}


data class User(
    val name: String,
    val weight: Double,
    val sex: String, // "male" or "female"
    val totalAlcoholConsumed: Double
)


