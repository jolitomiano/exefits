package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.exefitness.R

@Composable
fun Challenge(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image that fills the entire screen
        Image(
            painter = painterResource(id = R.drawable.back3),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Content Layer
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Title
            Text(
                text = "Challenge",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 32.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Challenge Buttons Grid
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ChallengeButton(text = "7-Days\nBicycling\nChallenge", iconRes = R.drawable.bicycle, route = Route.Bicycling, navController = navController)
                    ChallengeButton(text = "7-Days\nRunning\nChallenge", iconRes = R.drawable.jogging, route = Route.Running, navController = navController)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ChallengeButton(text = "30-Days\nAbs\nChallenge", iconRes = R.drawable.lifting, route = Route.Abs, navController = navController)
                    ChallengeButton(text = "7-Days\nWalking\nChallenge", iconRes = R.drawable.walking, route = Route.Walking, navController = navController)
                }
            }

            Spacer(modifier = Modifier.weight(1f)) // Pushes the navigation to the bottom

            // Bottom Navigation Row
            Row(
                modifier = Modifier
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
    }
}

@Composable
fun ChallengeButton(text: String, iconRes: Int, route: String, navController: NavController) {
    Button(
        onClick = { navController.navigate(route) },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDA15E)),
        modifier = Modifier
            .size(width = 130.dp, height = 130.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun NavigationIcon(iconRes: Int, navController: NavController, route: String) {
    IconButton(onClick = { navController.navigate(route) }) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF80D8FF), shape = CircleShape)
                .padding(8.dp)
        )
    }
}
