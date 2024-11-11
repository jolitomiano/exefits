package com.sample.exefitness.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Setting(navController: NavController, useSet: UseSet) {
    val isUser = remember { mutableStateOf(useSet.userType == "user") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFB24592), Color(0xFFF15F79))
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Profile",
                style = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Display user information
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 32.dp)
            ) {
                ProfileField(label = "Name:", value = "${useSet.firstName} ${useSet.lastName}")
                ProfileField(label = "Age:", value = useSet.age)
                ProfileField(label = "Gender:", value = useSet.gender)
                ProfileField(label = "Birthdate:", value = useSet.birthdate)
                ProfileField(label = "User Type:", value = useSet.userType)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Login as Admin button
            if (isUser.value) {
                Button(
                    onClick = {
                        useSet.userType = "admin"
                        isUser.value = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Login as Admin",
                        color = Color(0xFFB24592),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                AdminControls() // Admin-only controls
            }

            Spacer(modifier = Modifier.weight(1f)) // This spacer will push the navigation to the bottom

            // Bottom Navigation Row
            Row(
                modifier = Modifier // Corrected here
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
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
fun ProfileField(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun AdminControls() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Admin Controls", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)

        // Button to add a new exercise
        Button(
            onClick = { /* logic to add exercise */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Add Exercise", color = Color(0xFFB24592), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // Button to adjust exercise time
        Button(
            onClick = { /* logic to adjust time */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Set Exercise Time", color = Color(0xFFB24592), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun NavigationIcon(iconType: String, navController: NavController, route: String) {
    val icon: ImageVector = when (iconType) {
        "Plan" -> Icons.Filled.List
        "Discover" -> Icons.Filled.Search
        "History" -> Icons.Filled.AddCircle
        "Profile" -> Icons.Filled.Person
        else -> Icons.Filled.List // Default fallback
    }

    IconButton(onClick = { navController.navigate(route) }) {
        Icon(
            imageVector = icon,
            contentDescription = "$iconType Icon",
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
    }
}
