package com.example.bactrack.uiScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue

@Composable
fun DisplayOne() {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        com.example.bactrack.uiElements.AlertDialog (onDismiss = {showDialog = false})
    }

    Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFFADD8E6)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
            ) {
            Button(onClick = { showDialog = true } ) {
                Text(text = "Add a drink +")
            }
        }
    }
}