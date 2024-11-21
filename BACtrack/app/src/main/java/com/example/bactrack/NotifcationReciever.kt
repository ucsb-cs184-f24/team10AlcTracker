package com.example.bactrack

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class DrinkActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ADD_SHOT") {
            // Handle the action here
            Log.d("DrinkActionReceiver", "Add Drink button pressed.")

            // You can add logic to add a drink, update UI, or start an activity
            // Example: Start LandingActivity or any action you need
            val landingIntent = Intent(context, Landing::class.java)
            landingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            SessionManager.addDrink("shot")
            Toast.makeText(context, "Drink added", Toast.LENGTH_SHORT).show()

        }
        else if (intent.action == "ADD_BEER"){
            Log.d("DrinkActionReceiver", "Add Drink button pressed.")

            // You can add logic to add a drink, update UI, or start an activity
            // Example: Start LandingActivity or any action you need
            val landingIntent = Intent(context, Landing::class.java)
            landingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            SessionManager.addDrink("beer")
            Toast.makeText(context, "Drink added", Toast.LENGTH_SHORT).show()
        }

    }
}
