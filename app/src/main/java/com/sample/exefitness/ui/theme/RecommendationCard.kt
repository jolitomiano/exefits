package com.sample.exefitness.ui.theme



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.navigation.NavController

@Composable
fun RecommendationCard(navController: NavController,condition: String) {
    // Health advice for specific conditions
    val recommendation = when (condition) {
        "Asthma" -> "Recommended Exercises: Walking, Yoga, Light Strength Training. Avoid high-intensity cardio."
        "Obesity" -> "Recommended Exercises: Low-impact cardio, swimming, strength training. Aim for 30 mins daily."
        "Cardiovascular" -> "Recommended Exercises: Moderate cardio, cycling, stretching. Consult with your doctor."
        "Chronic Pain" -> "Recommended Exercises: Stretching, low-intensity yoga, aquatic therapy. Avoid high-impact exercises."
        "Epilepsy" -> "Recommended Exercises: Walking, light aerobic exercises, avoid swimming alone and high-altitude activities."
        "Stroke Recovery" -> "Recommended Exercises: Physical therapy exercises, light stretching, balance exercises."
        "Hypertension" -> "Recommended Exercises: Walking, cycling, breathing exercises. Avoid heavy lifting."
        "Diabetes" -> "Recommended Exercises: Cardio like brisk walking, strength training. Monitor blood sugar levels."
        "Other Specify" -> "Full Access to All Exercises"
        else -> "General Health Advice: Always consult your healthcare provider before starting a new exercise regimen."
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = condition,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = recommendation,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                )
            )
        }
    }
}
