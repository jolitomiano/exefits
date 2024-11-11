import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sample.exefitness.ui.theme.Route.UseSet
import com.sample.exefitness.ui.theme.UseSet


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue



class UseSetViewModel : ViewModel() {
    var useSet by mutableStateOf(
        UseSet(
            firstName = "John",
            lastName = "Doe",
            age = "25",
            gender = "Male",
            birthdate = "1998-01-01",
            userType = "User"
        )
    )
}
