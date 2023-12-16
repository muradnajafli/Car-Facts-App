package com.muradnajafli.carfactsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.carfactsapp.data.utils.Car
import com.muradnajafli.carfactsapp.ui.FactComposable
import com.muradnajafli.carfactsapp.ui.FactsViewModel
import com.muradnajafli.carfactsapp.ui.TextComponent
import com.muradnajafli.carfactsapp.ui.TextWithShadow
import com.muradnajafli.carfactsapp.ui.TopBar

@Composable
fun WelcomeScreen(
    userName: String?,
    car: String?,
) {
    val selectedCar = Car.fromString(car ?: "Unknown")
    val factsViewModel = FactsViewModel(selectedCar)

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar(
                value = "Welcome $userName! \uD83D\uDE97"
            )

            TextComponent(textValue = "Thank you for sharing your information", textSize = 24.sp)

            Spacer(modifier = Modifier.height(20.dp))

            TextWithShadow(value = "You are a $car lover!")

            Spacer(modifier = Modifier.height(20.dp))

            FactComposable(
                value = factsViewModel.fact,
                changeQuote = { factsViewModel.changeFact(selectedCar) }
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("Murad", "BMW")
}