package com.sample.exefitness.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Recommend(navController: NavController, selectedConditions: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFB24592),
                        Color(0xFFF15F79)
                    )
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Health Recommendations",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        // Display personalized recommendations based on conditions
        selectedConditions.forEach { condition ->
            RecommendationCard(navController = navController, condition = condition) // Corrected here
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Button to navigate back to home or other pages
        Button(
            onClick = { navController.navigate(Route.Home) },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text("Back to Home", color = Color.Black, fontSize = 18.sp)
        }
    }
}
