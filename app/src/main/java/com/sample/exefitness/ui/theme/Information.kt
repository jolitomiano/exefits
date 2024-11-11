package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.exefitness.R
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Information(navController: NavController, useSet: UseSet) {
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var age by remember { mutableStateOf(TextFieldValue()) }
    var birthdate by remember { mutableStateOf(TextFieldValue()) }
    var gender by remember { mutableStateOf("Male") }
    var showError by remember { mutableStateOf(false) }

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
            // Logo at the top
            Image(
                painter = painterResource(id = R.drawable.logoback),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Information text
            Text(
                text = "Information",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // First Name TextField
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name:", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Last Name TextField
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name:", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Age TextField
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age:", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Birthdate TextField
            OutlinedTextField(
                value = birthdate,
                onValueChange = { birthdate = it },
                label = { Text("Birthdate (e.g., YYYY-MM-DD):", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Gender Selection
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Male", color = Color.White)
                RadioButton(
                    selected = gender == "Male",
                    onClick = { gender = "Male" }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Female", color = Color.White)
                RadioButton(
                    selected = gender == "Female",
                    onClick = { gender = "Female" }
                )
            }

            // Show error message if input validation fails
            if (showError) {
                Text(
                    text = "Please fill in all fields.",
                    color = Color.Red,
                    style = TextStyle(fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
            onClick = {
                if (firstName.text.isNotBlank() && lastName.text.isNotBlank() && age.text.isNotBlank() && birthdate.text.isNotBlank()) {
                    // Update user data
                    useSet.firstName = firstName.text
                    useSet.lastName = lastName.text
                    useSet.age = age.text
                    useSet.birthdate = birthdate.text
                    useSet.gender = gender

                    navController.navigate(Route.Condition)
                } else {
                    showError = true
                }
            },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        ) {
            Text(
                text = "Continue",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
        }
    }
}