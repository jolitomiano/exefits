package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.exefitness.R

@Composable
fun Cardio(navController: NavController) {
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Cardio",
                color = Color.White, // Added text color for better visibility
                fontSize = 50.sp // Adjust font size as needed
            )

            Button(
                onClick = { navController.navigate(Route.Home) }, // Correct navigation action
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .width(200.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Home",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }
        }
    }
}
