package com.muradnajafli.carfactsapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.muradnajafli.carfactsapp.data.utils.Car

class FactsViewModel(selectedCar: Car) : ViewModel() {

    var fact by mutableStateOf(generateRandomFact(selectedCar))

    fun changeFact(selectedCar: Car) {
        fact = generateRandomFact(selectedCar)
    }

    private fun generateRandomFact(selectedCar: Car): String {
        return selectedCar.facts.random()
    }

}