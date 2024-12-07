package com.example.bactrack
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat


object SessionManager {
    var currentSession by mutableStateOf(CurrentSession())
    var firstDrinkTime: Long? = null
    private val customDrinkContributions = mutableListOf<Double>()
    private var _customDrinkCount = mutableStateOf(0) // Use mutableStateOf to track changes

    // Expose customDrinkCount as a read-only property
    val customDrinkCount: Int
        get() = _customDrinkCount.value

    val historyList = mutableStateListOf<BACSession>()

    val totalDrinks: Int
        get() = currentSession.numBeers +
                currentSession.numWine +
                currentSession.numShots +
                currentSession.numCocktails +
                customDrinkCount // Now tracks changes to _customDrinkCount

    val totalAlcMass: Double
        get() = (currentSession.numBeers * 14.0) +
                (currentSession.numWine * 20.8) +
                (currentSession.numShots * 14.0) +
                (currentSession.numCocktails * 27.1) +
                customDrinkContributions.sum()

    fun addCustomDrink(alcoholName: String, alcoholWeight: Double, context: Context) {
        // Add the alcohol weight to the custom drink contributions
        customDrinkContributions.add(alcoholWeight)
        _customDrinkCount.value++ // Increment the custom drink count explicitly
        // Trigger BAC recalculation
        if (firstDrinkTime == null) firstDrinkTime = System.currentTimeMillis()
        recalculateBAC(context)
    }

    var bac by mutableStateOf(0.0)
    var peakBac by mutableStateOf(0.0)
    var start by mutableStateOf(false)

    fun addDrink(drinkType: String, context: Context) {
        currentSession = when (drinkType) {
            "beer" -> currentSession.copy(numBeers = currentSession.numBeers + 1)
            "wine" -> currentSession.copy(numWine = currentSession.numWine + 1)
            "shot" -> currentSession.copy(numShots = currentSession.numShots + 1)
            "cocktail" -> currentSession.copy(numCocktails = currentSession.numCocktails + 1)
            else -> currentSession
        }
        if (firstDrinkTime == null) firstDrinkTime = System.currentTimeMillis()
        recalculateBAC(context)
    }

    fun recalculateBAC(context: Context) {
        val elapsedTime = getElapsedTimeInHours()
        val user = PersonManager.mainUser
        bac = calculateBAC(totalAlcMass, user.weight, if (user.sex) "male" else "female", elapsedTime)

        if (bac > peakBac) {
            peakBac = bac
        }

        Log.d("BAC", "$bac")
        Log.d("TIMEGOING", "$elapsedTime")

        // If BAC exceeds 0.3, try to make a call to the emergency contact
        if (bac > 0.3) {
            val emergencyContact = user.emergencyContactNum.toString()
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$emergencyContact")
            }

            // Check if the CALL_PHONE permission is granted
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                context.startActivity(intent)
            } else {
                Log.w("BAC", "CALL_PHONE permission not granted. Cannot call emergency contact.")
            }
        }

        // Save session when BAC is very low
        if (bac < 0.0001 && firstDrinkTime != null) {
            val session = BACSession(
                startTime = firstDrinkTime!!,
                endTime = System.currentTimeMillis(),
                peakBAC = peakBac,
                duration = System.currentTimeMillis() - firstDrinkTime!!
            )
            historyList.add(session)

            // Reset session data
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
