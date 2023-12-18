package com.muradnajafli.carfactsapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.muradnajafli.carfactsapp.data.UserDataUiEvents
import com.muradnajafli.carfactsapp.data.UserInputScreenState


class UserInputViewModel : ViewModel() {

    var uiState by mutableStateOf(UserInputScreenState())
        private set

    fun onEvent(event: UserDataUiEvents) {
        uiState = when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.copy(
                    enteredName = event.name
                )
            }

            is UserDataUiEvents.CarSelected -> {
                uiState.copy(
                    selectedCar = event.car
                )
            }
        }

    }

    fun isValidState(): Boolean {
        return uiState.enteredName.isNotEmpty()
                && uiState.selectedCar.isNotEmpty()

    }
}
