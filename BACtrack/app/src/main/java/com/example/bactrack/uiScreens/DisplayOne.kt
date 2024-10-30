package com.example.bactrack.uiScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DisplayOne() {

    Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFFADD8E6)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
            ) {
            Button(onClick = {/*TODO*/}) {
                Text(text = "Add a drink +")
            }
        }
    }
}