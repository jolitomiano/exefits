package com.sample.exefitness.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.exefitness.R

import androidx.compose.foundation.background // for the background modifier

@Composable
fun Condition(navController: NavController, selectedConditions: MutableList<String>) {
    // Define the list of conditions
    val conditions = listOf(
        "Asthma", "Obesity", "Cardiovascular", "Chronic Pain",
        "Epilepsy", "Stroke Recovery", "Hypertension", "Diabetes", "Normal"
    )

    // State to manage error visibility
    var showError by remember { mutableStateOf(false) }

    // Background set to white
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Correct usage of background modifier
    ) {
        // Content Layer
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Added padding for overall margin
        ) {
            Text(
                text = "Do you have Conditions?",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp) // Margin below title
            )

            // Checkbox list
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                conditions.forEach { condition ->
                    val isChecked = selectedConditions.contains(condition)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp) // Vertical space between checkboxes
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = {
                                if (isChecked) {
                                    selectedConditions.remove(condition)
                                } else {
                                    selectedConditions.add(condition)
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = condition, color = Color.Black, fontSize = 16.sp)
                    }
                }
            }

            // Show error message if no conditions are selected
            if (showError) {
                Text(
                    text = "Please select at least one condition.",
                    color = Color.Red,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp) // Error message padding
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Push button to the bottom

            // Continue Button
            Button(
                onClick = {
                    // Check if at least one condition is selected
                    if (selectedConditions.isNotEmpty()) {
                        navController.navigate(Route.Bmi)
                    } else {
                        showError = true // Show error if validation fails
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp)
                    .border(1.dp, Color.Black, shape = CircleShape),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE7C8FF) // Updated parameter
                )
            ) {
                Text(text = "Continue", color = Color.Black, fontSize = 18.sp)
            }
        }
    }
}
