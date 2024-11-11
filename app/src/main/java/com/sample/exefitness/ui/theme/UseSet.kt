package com.sample.exefitness.ui.theme

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class UseSet : ViewModel() {
    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var age by mutableStateOf("")
    var birthdate by mutableStateOf("")
    var gender by mutableStateOf("Male")
    var userType by mutableStateOf("User") // This can be set to "Admin" or "User"
}
