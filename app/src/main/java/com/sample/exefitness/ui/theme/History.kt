package com.sample.exefitness.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun History(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Text(text = "HISTORY", fontSize = 24.sp)

        // Tabs Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Calendar", fontSize = 16.sp)
            Text("Duration", fontSize = 16.sp)
            Text("Calories", fontSize = 16.sp, color = Color.Green) // Active tab
        }

        // Calories Graph Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Graph Placeholder", color = Color.DarkGray)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Activity section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "November 2024", fontSize = 18.sp)
            Text(text = "0 Activities", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "🏅", fontSize = 32.sp)
            Text(text = "Workout records will display here. Also, you can record your own activities!", fontSize = 14.sp)

            Spacer(modifier = Modifier.height(16.dp))

            // Add activities button
            Button(
                onClick = { /* Action for adding activities */ },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Green color
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .width(200.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Add activities manually",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NavigationIcon(iconType = "Plan", navController, Route.Home)
            NavigationIcon(iconType = "Discover", navController, Route.Challenge)
            NavigationIcon(iconType = "History", navController, Route.History)
            NavigationIcon(iconType = "Profile", navController, Route.Setting)
        }
    }
}
