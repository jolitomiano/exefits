package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun Bmi(navController: NavController) {
    // State variables for user input and result
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    // Function to calculate BMI and category
    fun calculateBmi() {
        val weightValue = weight.toFloatOrNull()
        val heightValue = height.toFloatOrNull()?.div(100) // Convert cm to meters
        if (weightValue != null && heightValue != null && heightValue > 0) {
            val bmi = weightValue / (heightValue * heightValue)
            result = String.format("%.2f", bmi)
            category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal weight"
                bmi < 29.9 -> "Overweight"
                else -> "Obesity"
            }
        } else {
            result = ""
            category = ""
        }
    }

    // Trigger BMI calculation automatically whenever weight or height changes
    LaunchedEffect(weight, height) {
        calculateBmi()
    }

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
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Main content at the top
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "BMI",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Weight Input
                Text(
                    text = "Weight (Kg):",
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    modifier = Modifier.align(Alignment.Start)
                )
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    placeholder = { Text(text = "Enter weight in Kg", color = Color.White) },
                    singleLine = true,
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Height Input
                Text(
                    text = "Height (cm):",
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    modifier = Modifier.align(Alignment.Start)
                )
                OutlinedTextField(
                    value = height,
                    onValueChange = { height = it },
                    placeholder = { Text(text = "Enter height in cm", color = Color.White) },
                    singleLine = true,
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Result Display
                Text(
                    text = "BMI: $result",
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = "Category: $category",
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Bottom buttons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Continue Button
                Button(
                    onClick = { navController.navigate(Route.Home) },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .width(150.dp)
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
}
