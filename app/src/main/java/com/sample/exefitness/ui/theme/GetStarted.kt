package com.sample.exefitness.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.exefitness.R

@Composable
fun GetStarted(navController: NavController) {


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image that fills the entire screen
        Image(
            painter = painterResource(id = R.drawable.pinkba),
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
            Spacer(modifier = Modifier.height(15.dp))
            // Top content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Logo at the top
                val logo: Painter = painterResource(id = R.drawable.logoback)
                Image(
                    painter = logo,
                    contentDescription = "Logo",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                // App name
                Text(
                    text = "ExeFit",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Subtitle text
                Text(
                    text = "Fitness, Your Way",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }

            // Spacer to lift the button a bit higher
            Spacer(modifier = Modifier.height(12.dp))

            // "Get Started" button
            Button(
                onClick = { navController.navigate(Route.Information) },
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
                    text = "Get Started",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            // Additional spacer at the bottom to create a small gap
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}
