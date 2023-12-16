package com.muradnajafli.carfactsapp

import androidx.compose.ui.graphics.Color

object ShadowColors {

    fun generateRandomColor(): Color {
        val colors = listOf(
            Color(0xFFE57373),
            Color(0xFFBA68C8),
            Color(0xFF7986CB),
            Color(0xFF4FC3F7),
            Color(0xFF4DB6AC),
            Color(0xFF81C784),
            Color(0xFFFF8A65),
            Color(0xFFA1887F),
            Color(0xFF90A4AE)
        )
        return colors.random()
    }
}