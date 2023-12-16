package com.muradnajafli.carfactsapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muradnajafli.carfactsapp.R
import com.muradnajafli.carfactsapp.data.UserDataUiEvents
import com.muradnajafli.carfactsapp.ui.ButtonComponent
import com.muradnajafli.carfactsapp.ui.CarCard
import com.muradnajafli.carfactsapp.ui.TextComponent
import com.muradnajafli.carfactsapp.ui.TextFieldComponent
import com.muradnajafli.carfactsapp.ui.TopBar
import com.muradnajafli.carfactsapp.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel = hiltViewModel(),
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Hi There! \uD83D\uDE80")

            TextComponent(
                textValue = "Let's learn about you",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided on you!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(36.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChange = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like?", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                CarCard(
                    image = R.drawable.bmw, carSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CarSelected(it)
                        )},
                    isSelected = userInputViewModel.uiState.selectedCar == "BMW")

                CarCard(
                    image = R.drawable.porsche, carSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CarSelected(it)
                        )},
                    isSelected = userInputViewModel.uiState.selectedCar == "Porsche")
            }
            
            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.enteredName,
                                userInputViewModel.uiState.selectedCar
                            )
                        )
                    }
                )
            }

        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(
        showWelcomeScreen = {
            Pair("Murad", "BMW")
        }
    )
}
