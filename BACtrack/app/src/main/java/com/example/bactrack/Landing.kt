package com.example.bactrack
import com.example.bactrack.SessionManager.totalAlcMass
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsBar


import androidx.compose.material.icons.filled.WineBar

import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SportsBar
import androidx.compose.material3.*
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable


import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.bactrack.ui.theme.BACtrackTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.filled.AttachEmail
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsBar
import androidx.compose.material.icons.filled.WineBar
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SportsBar
import androidx.compose.material3.*
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bactrack.SessionManager.totalAlcMass
import com.example.bactrack.ui.theme.BACtrackTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

class Landing : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BACtrackTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false
                    ),
                    BottomNavigationItem(
                        title = "Your History",
                        selectedIcon = Icons.Filled.SportsBar,
                        unselectedIcon = Icons.Outlined.SportsBar,
                        hasNews = false
                    ),
                    BottomNavigationItem(
                        title = "Profile",
                        selectedIcon = Icons.Filled.Face,  // Choose an appropriate icon for profile
                        unselectedIcon = Icons.Outlined.Face,
                        hasNews = false
                    )
                )
                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

                var navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFADD8E6) //color can be subject to change
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = items,
                                selectedItemIndex = selectedItemIndex,
                                onItemSelected = { index ->
                                    selectedItemIndex = index
                                    when(index) {
                                        0 -> navController.navigate("home")
                                        1 -> navController.navigate("history")
                                        2 -> navController.navigate("profile")
                                    }
                                }
                            )
                        }
                    ) { paddingValues -> // This will ensure our main content is not covered by the bottom bar
                        NavHost(
                            navController = navController,
                            startDestination = "home",
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            composable("home") { HomeScreen() }
                            composable("history") { HistoryScreen() }
                            composable("profile") { ProfileMenu() }
                        }
                    }
                }
            }
        }
    }
}

data class BottomNavigationItem (
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    //this will represent a number of notifications the icon will contain (optional)
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BACtrackTheme {
        Greeting("Android")
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index)},
                label = { Text(text = item.title) },
                icon = {
                    BadgedBox( ////////////////this is boiler plate code for the event we want to add notifications to the icons
                        badge = {
                            if(item.badgeCount != null) {
                                Badge{ Text(text = item.badgeCount.toString()) }
                            } else if(item.hasNews) { Badge()}
                        }
                    ) { ///////////////////////
                        Icon(
                            imageVector = if(index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        )
                    }
                }
            )

        }
    }
}

@Composable
fun AnimatedBackground(content: @Composable () -> Unit) {
    // Infinite transition for animated background gradient
    val infiniteTransition = rememberInfiniteTransition()
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFF6F61),
        targetValue = Color(0xFFFECA57),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFFAB91),
        targetValue = Color(0xFFFF7043),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Define particle data class and particles setup
    data class Particle(
        val initialX: Float,
        val initialY: Float,
        val size: Float,
        val color: Color,
        val speedX: Float,
        val speedY: Float
    )

    val particles = remember {
        List(200) { // Adjust for more or fewer particles
            Particle(
                initialX = (0..1000).random().toFloat(),
                initialY = (0..2000).random().toFloat(),
                size = (5..15).random().toFloat(),
                color = Color(0x80FFFFFF), // Semi-transparent white
                speedX = (-1..1).random().toFloat(),
                speedY = (-1..1).random().toFloat()
            )
        }
    }

    // Animate particle positions
    val animatedParticles = particles.map { particle ->
        val offsetX by infiniteTransition.animateFloat(
            initialValue = particle.initialX,
            targetValue = particle.initialX + particle.speedX * 700,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = (3000..7000).random(), easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val offsetY by infiniteTransition.animateFloat(
            initialValue = particle.initialY,
            targetValue = particle.initialY + particle.speedY * 700,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = (3000..7000).random(), easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        particle.copy(initialX = offsetX, initialY = offsetY)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(color1, color2),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            // Draw particles on top of the gradient
            animatedParticles.forEach { particle ->
                Box(
                    modifier = Modifier
                        .offset(particle.initialX.dp, particle.initialY.dp)
                        .size(particle.size.dp)
                        .background(particle.color, shape = CircleShape)
                )
            }
            content() // Placeholder for screen-specific content
        }
    }
}

@Composable
fun HomeScreen() {
    var counter by remember { mutableStateOf(0) }
    val maxCounter = 0.2
    // For BAC calculation
    val currentBAC by remember { derivedStateOf { SessionManager.bac } }
    val fillLevel by animateFloatAsState(targetValue = (currentBAC.toFloat() / maxCounter.toFloat()).coerceIn(0f, 1f))
    var showDrinkDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(60_000L) // 1 minute
            SessionManager.recalculateBAC()
        }
    }



    // Infinite transition for animated background gradient
    val infiniteTransition = rememberInfiniteTransition()
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFF6F61),
        targetValue = Color(0xFFFECA57),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFFAB91),
        targetValue = Color(0xFFFF7043),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    data class Particle(
        val initialX: Float,
        val initialY: Float,
        val size: Float,
        val color: Color,
        val speedX: Float,
        val speedY: Float
    )


    // Particles setup
    val particles = remember {
        List(200) { // Adjust for more or fewer particles
            Particle(
                initialX = (0..1000).random().toFloat(),
                initialY = (0..2000).random().toFloat(),
                size = (5..15).random().toFloat(),
                color = Color(0x80FFFFFF), // Semi-transparent white
                speedX = (-1..1).random().toFloat(),
                speedY = (-1..1).random().toFloat()
            )
        }
    }

    // Animate particle positions
    val animatedParticles = particles.map { particle ->
        val offsetX by infiniteTransition.animateFloat(
            initialValue = particle.initialX,
            targetValue = particle.initialX + particle.speedX * 700, // Adjust range as needed
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = (3000..7000).random(), easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val offsetY by infiniteTransition.animateFloat(
            initialValue = particle.initialY,
            targetValue = particle.initialY + particle.speedY * 700, // Adjust range as needed
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = (3000..7000).random(), easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        particle.copy(initialX = offsetX, initialY = offsetY)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent // We use the gradient background instead
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(color1, color2),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f) // Use finite values here
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            // Draw particles on top of the gradient
            animatedParticles.forEach { particle ->
                Box(
                    modifier = Modifier
                        .offset(particle.initialX.dp, particle.initialY.dp)
                        .size(particle.size.dp)
                        .background(particle.color, shape = CircleShape)
                )
            }

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.bactrack_logo_better),
                        contentDescription = "BACtrack Logo",
                        modifier = Modifier
                            .size(160.dp)
                            .padding(top = 24.dp)
                    )
                }
                item {
                    Text(
                        text = "\uD83C\uDF7B Welcome to BACtrack! \uD83C\uDF77 ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .shadow(4.dp, shape = MaterialTheme.shapes.medium)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color.Magenta, Color.Blue, Color.Cyan)
                                ),
                                shape = MaterialTheme.shapes.medium
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                item {
                    Button(
                        onClick = { showDrinkDialog = true }, // Show the dialog when clicked
                        modifier = Modifier.padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),

                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(
                            text = "Add a Drink",
                            color = Color(0xFFFF7F50),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                item {
                    Mug(fillLevel = fillLevel)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Button(
                            onClick = { if (counter < maxCounter) counter++ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00ACC1)),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Add More", color = Color.White)
                        }
                        Button(
                            onClick = { if (counter > 0) counter-- },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00838F)),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Icon(Icons.Default.Remove, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Reduce", color = Color.White)
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color(0xFF1B5E20), shape = MaterialTheme.shapes.medium)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Total Drinks: ${SessionManager.totalDrinks}",
                            color = Color(0xFFFFD700),
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color(0xFF263238), shape = MaterialTheme.shapes.medium)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Current BAC: ${currentBAC.format(3)}",
                            color = Color(0xFF76FF03),
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }
            if (showDrinkDialog) {
                DrinkSelectionDialog(onDismiss = { showDrinkDialog = false })
            }

        }
    }
}



@Composable
fun DrinkOptionRow(drinkType: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726)),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = "$drinkType Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(drinkType, color = Color.White)
        }
    }
}


@Composable
fun DrinkSelectionDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("What did you drink?", fontWeight = FontWeight.Bold)
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DrinkOptionRow(
                    drinkType = "Beer",
                    icon = Icons.Filled.SportsBar,
                    onClick = {
                        SessionManager.addDrink("beer")
                        onDismiss()
                    }
                )
                DrinkOptionRow(
                    drinkType = "Wine",
                    icon = Icons.Filled.WineBar,
                    onClick = {
                        SessionManager.addDrink("wine")
                        onDismiss()
                    }
                )
                DrinkOptionRow(
                    drinkType = "Shot",
                    icon = Icons.Filled.LocalDrink,
                    onClick = {
                        SessionManager.addDrink("shot")
                        onDismiss()
                    }
                )
                DrinkOptionRow(
                    drinkType = "Cocktail",
                    icon = Icons.Filled.LocalBar,
                    onClick = {
                        SessionManager.addDrink("cocktail")
                        onDismiss()
                    }
                )
            }
        },
        confirmButton = {},
        dismissButton = {
            Button(onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ){
                Text("Cancel",
                    color = Color.White)
            }
        }
    )
}








@Composable
fun Mug(fillLevel: Float) {
    val mugWidth = 120.dp
    val mugHeight = 180.dp
    val handleWidth = 40.dp
    val handleHeight = 100.dp
    val glassThickness = 8f
    val frothHeight = 40.dp

    // Add padding or offset to adjust the position of the mug
    Canvas(
        modifier = Modifier
            .size(mugWidth + handleWidth, mugHeight + frothHeight)
            .padding(top = 20.dp) // Adjust this to move vertically
            .offset(x = 20.dp) // Adjust this to move horizontally
    ) {
        val mugBodyWidth = size.width - handleWidth.toPx()
        val mugBodyHeight = size.height - frothHeight.toPx()


        // Draw the filling (beer inside the mug)
        val beerBrush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFFD54F), // Lighter yellow (beer top)
                Color(0xFFFFA000)  // Darker golden (beer bottom)
            ),
            startY = size.height * (1 - fillLevel),
            endY = size.height
        )

        drawRect(
            brush = beerBrush,
            size = androidx.compose.ui.geometry.Size(
                mugBodyWidth,
                mugBodyHeight * fillLevel
            ),
            topLeft = Offset(0f, mugBodyHeight * (1 - fillLevel)),
        )


        // Draw the mug body (outer glass border) with a white outline
        drawRoundRect(
            color = Color.White, // White outline
            size = androidx.compose.ui.geometry.Size(mugBodyWidth, mugBodyHeight),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(20f, 20f),
            style = Stroke(width = glassThickness)
        )



        // Draw the frothy top only if the mug is not empty
        if (fillLevel > 0f) {
            val frothRadius = frothHeight.toPx() / 2
            val frothOffsetY = mugBodyHeight * (1 - fillLevel) - frothRadius * 0.5f // Closer to the filling

            // Add a base layer of froth (randomized smaller bubbles)
            for (i in 1..30) {
                val randomX = Random.nextFloat() * 0.8f * mugBodyWidth + mugBodyWidth * 0.1f
                val randomY = frothOffsetY + Random.nextFloat() * frothRadius - frothRadius / 2
                val randomRadius = Random.nextFloat() * (frothRadius * 0.4f) + frothRadius * 0.2f
                drawCircle(
                    color = Color.White.copy(alpha = Random.nextFloat() * 0.2f + 0.7f),
                    center = Offset(randomX, randomY),
                    radius = randomRadius
                )
            }

            // Add larger overlapping bubbles for a layered effect
            val frothCircles = listOf(
                Offset(mugBodyWidth * 0.15f, frothOffsetY),
                Offset(mugBodyWidth * 0.35f, frothOffsetY - frothRadius / 3),
                Offset(mugBodyWidth * 0.55f, frothOffsetY),
                Offset(mugBodyWidth * 0.75f, frothOffsetY - frothRadius / 3),
                Offset(mugBodyWidth * 0.85f, frothOffsetY)
            )

            frothCircles.forEach { circleCenter ->
                drawCircle(
                    color = Color.White.copy(alpha = 0.95f),
                    center = circleCenter,
                    radius = frothRadius * 0.8f
                )
            }
        }

        // Draw the handle
        val handleLeft = mugBodyWidth - glassThickness / 2
        val handleTop = mugBodyHeight / 2 - handleHeight.toPx() / 2
        drawArc(
            color = Color.White, // White outline for the handle
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = glassThickness),
            topLeft = Offset(handleLeft, handleTop),
            size = androidx.compose.ui.geometry.Size(handleWidth.toPx(), handleHeight.toPx())
        )

        // Add glass highlights (to make it shiny)
        drawLine(
            color = Color.White.copy(alpha = 0.4f),
            start = Offset(mugBodyWidth * 0.1f, mugBodyHeight * 0.1f),
            end = Offset(mugBodyWidth * 0.3f, mugBodyHeight * 0.9f),
            strokeWidth = 4f
        )
        drawLine(
            color = Color.White.copy(alpha = 0.4f),
            start = Offset(mugBodyWidth * 0.7f, mugBodyHeight * 0.1f),
            end = Offset(mugBodyWidth * 0.9f, mugBodyHeight * 0.9f),
            strokeWidth = 4f
        )
    }
}



fun Double.format(digits: Int) = "%.${digits}f".format(this)
@Composable
fun HistoryScreen() {
    AnimatedBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "History Screen",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
            // Add other content for HistoryScreen here
        }
    }
}


@Composable
fun SettingsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFADD8E6)
    ) {
        Text(
            text = "Settings Screen",
            color = Color.Black
        )
    }
}


data class CurrentSession(
    val numBeers: Int = 0,
    val numWine: Int = 0,
    val numShots: Int = 0,
    val numCocktails: Int = 0
) {

}




@Composable
fun ProfileMenu() {
    val menuItems = listOf("Your Data", "Health Info")
    var selectedMenuItem by remember { mutableStateOf("Your Data") }

    Row(modifier = Modifier.fillMaxSize()) {
        // Menu Column on the left
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .width(120.dp)
        ) {
            menuItems.forEach { item ->
                Button(
                    onClick = { selectedMenuItem = item },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedMenuItem == item) Color.Black else Color.Gray
                    )
                ) {
                    Text(text = item)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Display selected section
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .weight(1f)
        ) {
            when (selectedMenuItem) {
                "Your Data" -> PersonalInformationSection()
                "Health Info" -> HealthInfoSection()
//                "Preferences" -> PreferencesSection()
//                "Account Details" -> AccountDetailsSection()
//                "Settings" -> SettingsSection()
//                "Custom Sections" -> CustomSectionsSection()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInformationSection() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var name by remember { mutableStateOf(PersonManager.mainUser.name) }
    var dob by remember { mutableStateOf(PersonManager.mainUser.dateOfBirth) }
    var email by remember { mutableStateOf(PersonManager.mainUser.email) }
    var phone by remember { mutableStateOf(TextFieldValue(formatPhoneNumber(PersonManager.mainUser.phoneNumber.toString()))) }
    var emergencyNumber by remember {
        mutableStateOf(
            TextFieldValue(
                formatPhoneNumber(
                    PersonManager.mainUser.emergencyContactNum.toString()
                )
            )
        )
    }

    val calendarState = rememberSheetState()
    //convert Dob to displayable format
    val formattedDob = remember(dob) { formatDate(dob) }

    val focusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier.fillMaxSize()
            .clickable(
                onClick = { focusManager.clearFocus() },
                indication = null, //removes ripple effect
                interactionSource = MutableInteractionSource()
            ),
        color = Color(0xFFADD8E6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_user), // replace with actual profile picture
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EditableProfileField(
                label = "Name",
                value = name,
                keyboardOptions = KeyboardOptions.Default,
                maxLength = 20
            ) { newName ->
                if (newName.length <= 20) {
                    name = newName
                    PersonManager.mainUser.name = newName
                }
            }


            //this was needed in order to make the calendar display click correctly
            ClickableField(
                label = "Date of Birth",
                value = formattedDob,
                onClick = { calendarState.show() } // Open calendar on click
            )

            Spacer(modifier = Modifier.height(4.dp))

            CalendarDialog(
                state = calendarState,
                config = CalendarConfig(
                    monthSelection = true,
                    yearSelection = true,
                    style = CalendarStyle.MONTH
                ),
                selection = CalendarSelection.Date { date ->
                    val newDob = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                    dob = newDob
                    PersonManager.mainUser.dateOfBirth = newDob
                    Log.d("SelectedDate", "$date")
                }
            )
            ////////////////////////////////////////////////////////////////
            EditableProfileField(
                label = "Email",
                value = email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            ) { newEmail ->
                email = newEmail
                if (isValidEmail(newEmail)) {
                    PersonManager.mainUser.email = newEmail
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            EditablePhoneField(
                label = "Phone Number",
                value = phone,
                onValueChange = { newPhone ->
                    phone = newPhone // Update intermediate state
                    if (newPhone.text.length == 14) { // Update only if valid
                        PersonManager.mainUser.phoneNumber =
                            newPhone.text.filter { it.isDigit() }.toLong()
                    }
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Emergency Contact Field with formatting
            EditablePhoneField(
                label = "Emergency Contact",
                value = emergencyNumber,
                onValueChange = { newEmergencyNumber ->
                    emergencyNumber = newEmergencyNumber // Update intermediate state
                    if (newEmergencyNumber.text.length == 14) { // Update only if valid
                        PersonManager.mainUser.emergencyContactNum =
                            newEmergencyNumber.text.filter { it.isDigit() }.toLong()
                    }
                }
            )
        }
    }
}

//Helper function for formatDate
fun formatDate(date: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        LocalDate.parse(date, formatter).format(formatter)
    } catch (e: Exception) {
        ""
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    return emailRegex.matches(email)
}

fun formatPhoneNumber(input: String): String {
    val digits = input.filter { it.isDigit() }
    // format as (XXX) XXX-XXXX
    return when {
        digits.length >= 10 -> "(${digits.substring(0, 3)}) ${
            digits.substring(
                3,
                6
            )
        }-${digits.substring(6, 10)}"

        digits.length >= 6 -> "(${digits.substring(0, 3)}) ${
            digits.substring(
                3,
                6
            )
        }-${digits.substring(6)}"

        digits.length >= 3 -> "(${digits.substring(0, 3)}) ${digits.substring(3)}"
        else -> digits
    }
}

fun applyPhoneMask(input: String): String {
    val digits = input.filter { it.isDigit() }
    val builder = StringBuilder()

    for (i in digits.indices) {
        when (i) {
            0 -> builder.append("(")
            3 -> builder.append(") ")
            6 -> builder.append("-")
        }
        builder.append(digits[i])
    }

    return builder.toString().take(14) // Limit to (XXX) XXX-XXXX
}


@Composable
fun ClickableField(label: String, value: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    MaterialTheme.shapes.small
                )
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()

            ) {
                Icon(Icons.Filled.CalendarMonth, contentDescription = "Email Icon")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface

                )
            }

        }
    }
}

// Helper Composable for Profile Fields
@Composable
fun ProfileField(
    label: String,
    value: String,
    isEditing: Boolean,
    onValueChange: (String) -> Unit
) {
    if (isEditing) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        Text(
            text = "$label: $value",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthInfoSection() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var weight by remember { mutableStateOf(sharedPreferences.getString("weight", "") ?: "") }
    var gender by remember {
        mutableStateOf(
            sharedPreferences.getString("gender", "Female") ?: "Female"
        )
    }
    var showMessage by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFADD8E6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .imePadding(), //automatically adjusts padding when keyboard is open
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = weight,
                onValueChange = { newValue ->
                    if (newValue.isEmpty()) {
                        weight = ""
                    } else {
                        val weightValue = newValue.toDoubleOrNull()
                        if (weightValue != null && weightValue >= 0 && weightValue < 500) {
                            weight = newValue
                        }
                    }
                },
                label = { Text("Enter your weight (kg)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                leadingIcon = {
                    Icon(Icons.Filled.FitnessCenter, contentDescription = "Weight Icon")
                }
            )

            //drop down menu for gender selection
            dropDownMenu(
                selectedGender = gender,
                setSelectedGender = {
                    gender = it
                } // Lambda to update gender in HealthInfoSection
            )

            Spacer(modifier = Modifier.weight(1f)) // Push the button to the bottom

            Button(
                onClick = {
                    if (weight.isNotBlank() && gender.isNotBlank()) {
                        val editor = sharedPreferences.edit()
                        editor.putString("weight", weight)
                        editor.putString("gender", gender)
                        editor.apply()

                        val weightDouble = weight.toDoubleOrNull() ?: 70.0
                        val isMale = when (gender) {
                            "Male" -> true
                            "Female" -> false
                            else -> false //Assume non binary is female
                        }
                        PersonManager.setGender(isMale)
                        PersonManager.setWeight(weightDouble)
                        showMessage = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save")
            }

            if (showMessage) {
                Text(
                    text = "Details saved successfully!",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun dropDownMenu(
    selectedGender: String,
    setSelectedGender: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Male", "Female", "Other (Biological Male)", "Other (Biological Female)")
    var selectedItem by remember { mutableStateOf("") }

    var textFiledSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text("Select your gender") },
            readOnly = true,
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFiledSize.width.toDp() })
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    text = { Text(text = label) },
                    onClick = {
                        selectedItem = label
                        expanded = false
                        setSelectedGender(label)
                    }
                )
            }
        }
    }
}


@Composable
fun BodyMeasurementsTab() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var weight by remember { mutableStateOf(sharedPreferences.getString("weight", "") ?: "") }
    var height by remember { mutableStateOf(sharedPreferences.getString("height", "") ?: "") }
    var showMessage by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFADD8E6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Enter your weight (kg)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Enter your height (cm)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (weight.isNotBlank() && height.isNotBlank()) {
                    val editor = sharedPreferences.edit()
                    editor.putString("weight", weight)
                    editor.putString("height", height)
                    editor.apply()
                    showMessage = true
                }
            }) {
                Text(text = "Save Measurements")
            }

            if (showMessage) {
                Text(
                    text = "Measurements saved successfully!",
                    color = Color.Green,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun PreferencesTab() {
    // Placeholder for Preferences functionality
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFADD8E6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Preferences Section")

            // This is where you'd add preference settings like notifications, themes, etc.
            Button(onClick = { /* Implement preferences logic */ }) {
                Text(text = "Edit Preferences")
            }
        }
    }
}

@Composable
fun PreferencesSection() {
//    val context = LocalContext.current
//    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//    var notificationsEnabled by remember { mutableStateOf(sharedPreferences.getBoolean("notifications", true)) }
//    var themePreference by remember { mutableStateOf(sharedPreferences.getString("theme", "Light") ?: "Light") }
//
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Ensure `notificationsEnabled` is a `Boolean` and `themePreference` is a `String`
//            var notificationsEnabled by remember { mutableStateOf(false) }
//            var themePreference by remember { mutableStateOf("Light") }
//
//            // Pass the right lambda type
////            SwitchSetting("Enable Notifications", notificationsEnabled) { isEnabled: Boolean ->
////                notificationsEnabled = isEnabled
////            }
//
//            EditableProfileField("Theme Preference", themePreference) { newPreference: String ->
//                themePreference = newPreference
//            }
//        }
//    }


}

@Composable
fun SwitchSetting(x0: String, x1: Boolean, content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun AccountDetailsSection() {
//    val context = LocalContext.current
//    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//    var loginEmail by remember { mutableStateOf(sharedPreferences.getString("login_email", "") ?: "") }
//    var subscriptionPlan by remember { mutableStateOf(sharedPreferences.getString("subscription_plan", "Free") ?: "Free") }
//    var lastLogin by remember { mutableStateOf(sharedPreferences.getString("last_login", "") ?: "") }
//
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            EditableProfileField("Login Email", loginEmail) { loginEmail = it }
//            EditableProfileField("Subscription Plan", subscriptionPlan) { subscriptionPlan = it }
//            EditableProfileField("Last Login", lastLogin) { lastLogin = it }
//        }
//    }
}

@Composable
fun SettingsSection() {
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Settings Section")
//            Button(onClick = { /* Implement data export */ }) { Text("Export Data") }
//            Button(onClick = { /* Implement account deletion */ }) { Text("Delete Account") }
//        }
//    }
}

//currently not in use
@Composable
fun CustomSectionsSection() {
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Custom Sections")
//            EditableProfileField("Emergency Contact", "", isEditing = true, onValueChange = { /* Implement save logic */ })
//            EditableProfileField("Medical Restrictions", "", isEditing = true, onValueChange = { /* Implement save logic */ })
//        }
//    }
}

@Composable
fun EditablePhoneField(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            val digits = newValue.text.filter { it.isDigit() } // Extract only digits
            val formattedPhone = applyPhoneMask(digits) // Apply the mask
            onValueChange(
                TextFieldValue(
                    formattedPhone,
                    TextRange(formattedPhone.length)
                )
            ) // Update text and move cursor to the end
        },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            when (label) {
                "Phone Number" -> Icon(Icons.Filled.Call, contentDescription = "Phone Icon")
                "Emergancy Contact" -> Icon(
                    Icons.Filled.Emergency,
                    contentDescription = "EC Icon"
                )

                else -> Icon(Icons.Filled.Info, contentDescription = "Default Icon")
            }
        },
        modifier = Modifier.fillMaxWidth()

    )
}


@Composable
fun EditableProfileField(
    label: String,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (maxLength == null || newValue.length <= maxLength) {
                onValueChange(newValue)
            }
        },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        leadingIcon = {
            when (label) {
                "Name" -> Icon(Icons.Filled.Face, contentDescription = "Name Icon")
                "Email" -> Icon(Icons.Filled.AttachEmail, contentDescription = "Email Icon")
                else -> Icon(Icons.Filled.Info, contentDescription = "Default Icon")
            }

        }
    )
}