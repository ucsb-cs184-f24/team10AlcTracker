package com.example.bactrack

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object SessionManager {
    var currentSession by mutableStateOf(CurrentSession())
    var firstDrinkTime: Long? = null

    val totalDrinks: Int
        get() = currentSession.numBeers + currentSession.numWine + currentSession.numShots + currentSession.numCocktails

    val totalAlcMass: Double
        get() = (currentSession.numBeers * 14.0) +
                (currentSession.numWine * 20.8) +
                (currentSession.numShots * 14.0) +
                (currentSession.numCocktails * 27.1)

    var bac by mutableStateOf(0.0)

    fun addDrink(drinkType: String) {
        currentSession = when (drinkType) {
            "beer" -> currentSession.copy(numBeers = currentSession.numBeers + 1)
            "wine" -> currentSession.copy(numWine = currentSession.numWine + 1)
            "shot" -> currentSession.copy(numShots = currentSession.numShots + 1)
            "cocktail" -> currentSession.copy(numCocktails = currentSession.numCocktails + 1)
            else -> currentSession
        }
        if (firstDrinkTime == null) firstDrinkTime = System.currentTimeMillis()
        recalculateBAC()
    }

    fun recalculateBAC() {
        val elapsedTime = getElapsedTimeInHours()
        val user = PersonManager.mainUser
        bac = calculateBAC(totalAlcMass, user.weight, if (user.sex) "male" else "female", elapsedTime)
    }

    private fun getElapsedTimeInHours(): Double {
        return if (firstDrinkTime != null) {
            (System.currentTimeMillis() - firstDrinkTime!!) / 3600000.0
        } else 0.0
    }
}
