package com.example.bactrack

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class NotificationService : Service() {

    private val CHANNEL_ID = "bac_track_channel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        showNotification()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        showNotification()  // Show notification when service starts
        return START_STICKY
    }

    // Create Notification Channel (required for Android 8.0 and above)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "BACtrack Notifications"
            val descriptionText = "Channel for BACtrack drink tracking"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Create and show the notification
    private fun showNotification() {
        // Intent for the action button (PendingIntent)
        val addShot = Intent(applicationContext, DrinkActionReceiver::class.java).apply {
            action = "ADD_SHOT"
        }

        val pendingShotIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            addShot,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val addBeer = Intent(applicationContext, DrinkActionReceiver::class.java).apply {
            action = "ADD_BEER"
        }
        val pendingBeerIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            1,
            addShot,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )



        // Create the notification
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.bactrack_logo_better)  // Your app icon
            .setContentTitle("BACtrack")
            .setContentText("Track your drinks!")
            .addAction(R.drawable.bactrack_logo_better, "Add Shot", pendingShotIntent)
            .addAction(R.drawable.bactrack_logo_better, "Add Beer", pendingBeerIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setOngoing(true)  // Keeps the notification visible
            .build()

        // Show the notification
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
