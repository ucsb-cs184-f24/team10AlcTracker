package com.example.bactrack.uiElements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                //4 minute mark, pick up here!
            }
        }
    )
}