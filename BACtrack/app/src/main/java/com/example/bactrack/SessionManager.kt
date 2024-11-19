package com.example.bactrack

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object SessionManager {
    var currentSession by mutableStateOf(CurrentSession())

        //this value will dynamically update thanks to the get function
    val totalDrinks: Int
        get() = currentSession.numBeers + currentSession.numWine + currentSession.numShots + currentSession.numCocktails

    //this will return total mass of alcohol consumed in grams
    val totalAlcMass: Double
        get() = (currentSession.numBeers * 14.0) + (currentSession.numWine * 20.8) + (currentSession.numShots * 14) + (currentSession.numCocktails * 27.1)
}
//this is a global object that will be used to store the current session

