package com.muradnajafli.carfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.muradnajafli.carfactsapp.ui.screens.CarFactsNavigationGraph
import com.muradnajafli.carfactsapp.ui.theme.CarFactsAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarFactsAppTheme {
                CarFactsApp()
            }
        }
    }
    
    @Composable
    fun CarFactsApp() {
        CarFactsNavigationGraph()
    }
}
