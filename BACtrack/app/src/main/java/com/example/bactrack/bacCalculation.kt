package com.example.bactrack

//fun calculateBAC(totalAlcoholConsumed: Double, weight: Double, weightUnit: String, height: Double, heightUnit: String, sex: String, time: Double): Double {
//    // Convert weight to grams if necessary
//    val weightInGrams = when (weightUnit.lowercase()) {
//        "kg" -> weight * 1000  // kg to grams
//        "lb" -> weight * 453.592 // lb to grams
//        else -> throw IllegalArgumentException("Invalid weight unit. Use 'kg' or 'lb'.")
//    }
//
//    // Convert height to meters if necessary (not directly needed for BAC calculation but useful for user profiles)
//    val heightInMeters = when (heightUnit.lowercase()) {
//        "m" -> height  // already in meters
//        "ft" -> height * 0.3048  // ft to meters
//        else -> throw IllegalArgumentException("Invalid height unit. Use 'm' or 'ft'.")
//    }
//
//    // Constants
//    val r = if (sex.equals("female", ignoreCase = true)) 0.55 else 0.68  // Alcohol distribution ratio
//    val beta = 0.015  // Alcohol elimination rate
//
//    // Calculate BAC
//    val bac = (totalAlcoholConsumed / (r * weightInGrams)) - (beta * time)
//
//    // Return BAC, ensuring it's not negative
//    return if (bac < 0) 0.0 else bac
//}

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



