package com.sample.exefitness.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val useSetViewModel: UseSetViewModel = viewModel() // Retrieve the ViewModel
    val useSet = useSetViewModel.useSet // Access the UseSet instance

    // Mutable list to track selected conditions
    val selectedConditions = remember { mutableStateListOf<String>() }

    // Navigation graph
    NavHost(navController = navController, startDestination = Route.GetStarted) {
        composable(Route.GetStarted) {
            GetStarted(navController = navController)
        }
        composable(Route.Information) {
            Information(navController = navController, useSet)
        }
        composable(Route.Condition) {
            Condition(navController = navController, selectedConditions = selectedConditions)
        }
        composable(Route.Bmi) {
            Bmi(navController = navController)
        }
        composable(Route.Home) {
            Home(navController = navController)
        }
        composable(Route.Recommend) {
            Recommend(navController = navController, selectedConditions = selectedConditions)
        }
        composable(Route.Cardio) {
            Cardio(navController = navController)
        }
        composable(Route.Flexibility) {
            Flexibilty(navController = navController)
        }
        composable(Route.Challenge) {
            Challenge(navController = navController)
        }
        composable(Route.Strength) {
            Strength(navController = navController)
        }
        composable(Route.Setting) {
            Setting(navController = navController, useSet = useSet)
        }
        composable(Route.History) {
            History(navController = navController)
        }
    }
}
