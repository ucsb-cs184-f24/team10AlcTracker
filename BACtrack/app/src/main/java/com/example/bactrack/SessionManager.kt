package com.example.bactrack

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue

object SessionManager {
    var currentSession by mutableStateOf(CurrentSession())
    var firstDrinkTime: Long? = null
    val historyList = mutableStateListOf<BACSession>()
    val totalDrinks: Int
        get() = currentSession.numBeers + currentSession.numWine + currentSession.numShots + currentSession.numCocktails

    val totalAlcMass: Double
        get() = (currentSession.numBeers * 14.0) +
                (currentSession.numWine * 20.8) +
                (currentSession.numShots * 14.0) +
                (currentSession.numCocktails * 27.1)

    var bac by mutableStateOf(0.0)
    var peakBac by mutableStateOf(0.0)
    var start by mutableStateOf(false)
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
        if (bac > peakBac) {
            peakBac = bac
        }

        Log.d("BAC", "$bac")
        Log.d("TIMEGOING", "$elapsedTime")
        if (bac < 0.0001 && firstDrinkTime != null) {  // this is my best use right now, will cause issues if bac >= 0.001 because the initial bac is less than that after 1 shot.
            // Save session to history
            val session = BACSession(
                startTime = firstDrinkTime!!,
                endTime = System.currentTimeMillis(),
                peakBAC = peakBac,
                duration = System.currentTimeMillis() - firstDrinkTime!!
            )
            historyList.add(session)


            peakBac = 0.0
            firstDrinkTime = null
            currentSession = CurrentSession()
        }
    }

    private fun getElapsedTimeInHours(): Double {
        return if (firstDrinkTime != null) {
            (System.currentTimeMillis() - firstDrinkTime!!) / 3600000.0
        } else 0.0
    }
}
