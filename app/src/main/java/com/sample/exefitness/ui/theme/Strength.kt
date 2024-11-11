package com.sample.exefitness.ui.theme

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Strength(navController: NavController){
    Text(text = "Strength")
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