package com.muradnajafli.carfactsapp.data

sealed class UserDataUiEvents{
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class CarSelected(val car: String) : UserDataUiEvents()
}