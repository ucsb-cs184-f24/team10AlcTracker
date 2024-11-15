package com.example.bactrack.uiElements


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.SportsBar
import androidx.compose.material.icons.filled.WineBar

import com.example.bactrack.SessionManager


@Composable
fun AlertDialog(
    onDismiss: () -> Unit
) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {/*TODO*/ },
        modifier = Modifier.height(250.dp),

        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Privacy")
                Text(
                    text = "What did you drink?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { SessionManager.addDrink("beer") },
                        modifier = Modifier
                            .width(130.dp)
                            .padding(10.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.SportsBar, contentDescription = "Beer Icon")
                        Text(text = "Beer")
                    }

                    Button(
                        onClick = { SessionManager.addDrink("wine") },
                        modifier = Modifier
                            .width(130.dp)
                            .padding(10.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.WineBar, contentDescription = "Wine Icon")
                        Text(text = "Wine")
                    }
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { SessionManager.addDrink("shot") },
                        modifier = Modifier
                            .width(130.dp)
                            .padding(10.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.LocalDrink, contentDescription = "Shot Icon")
                        Text(text = "Shot")
                    }

                    Button(
                        onClick = { SessionManager.addDrink("cocktail") },
                        modifier = Modifier
                            .width(130.dp)
                            .padding(10.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.LocalBar, contentDescription = "Cocktail Icon")
                        Text(text = "Cocktail")
                    }
                }
            }
        }
    )
}