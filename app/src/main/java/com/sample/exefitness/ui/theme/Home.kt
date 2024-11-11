package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import com.sample.exefitness.R

@Composable
fun Home(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.back3),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Title and Progress Bar Section
            Text(
                text = "4 WEEKS",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = "SCULPT PERFECT ABS",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = 0.0f, // Adjust dynamically based on progress
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(6.dp),
                color = Color(0xFF81C784), // Progress bar color
                trackColor = Color.LightGray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Week 1",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "A Newbie-Friendly Start",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Days List
            for (day in 1..4) {
                DayCard(day = day, duration = "${5 + day} Min", exercises = "${10 + day * 2} Exercise")
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Bottom Navigation positioned at the bottom of the screen
        BottomNavigation(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Composable
fun DayCard(day: Int, duration: String, exercises: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // Day Image
            Image(
                painter = painterResource(id = R.drawable.profile), // Replace with correct image
                contentDescription = "Exercise Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
            )

            // Day Details
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Day $day",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "$duration · $exercises",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Arrow Icon
            IconButton(onClick = { /* Navigate to day's workout details */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.books), // Replace with arrow icon resource
                    contentDescription = "Arrow",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)) // Use clip instead of background for rounded corners
            .background(Color.White) // Apply background color
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationIcon(iconType = "Plan", navController, Route.Home)
        NavigationIcon(iconType = "Discover", navController, Route.Challenge)
        NavigationIcon(iconType = "History", navController, Route.History)
        NavigationIcon(iconType = "Profile", navController, Route.Setting)
    }

}

@Composable
fun Navi(iconType: String, navController: NavController, route: String) {
    IconButton(onClick = { navController.navigate(route) }) {
        val icon: ImageVector = when (iconType) {
            "Plan" -> Icons.Filled.List
            "Discover" -> Icons.Filled.Search
            "History" -> Icons.Filled.AddCircle
            "Profile" -> Icons.Filled.Person
            else -> Icons.Filled.List // Default fallback
        }

        Icon(
            imageVector = icon,
            contentDescription = "$iconType Icon",
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
    }
}
