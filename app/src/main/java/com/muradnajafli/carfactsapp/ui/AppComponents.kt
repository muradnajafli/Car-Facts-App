package com.muradnajafli.carfactsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.carfactsapp.ShadowColors
import com.muradnajafli.carfactsapp.R

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Jetpack Compose")
    }

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(value = "")
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black
) {
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Murad Najafli", textSize = 24.sp)
}

@Composable
fun TextFieldComponent(
    onTextChange: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(
            fontSize = 24.sp
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )


}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent(onTextChange = { })
}

@Composable
fun CarCard(
    image: Int, isSelected: Boolean,
    carSelected: (carName: String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp)
            .clickable {
                val carName =
                    when (image) {
                        R.drawable.bmw -> "BMW"
                        R.drawable.porsche -> "Porsche"
                        else -> ""
                    }
                carSelected(carName)
                localFocusManager.clearFocus()
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (isSelected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(),
                painter = painterResource(image),
                contentDescription = "Car Image"
            )
        }

    }
}

@Preview
@Composable
fun CarCardPreview() {
    CarCard(R.drawable.porsche, true, carSelected = { })
}

@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()
        }
    ) {
        TextComponent(
            textValue = "Go to Details Screen",
            textSize = 20.sp,
            colorValue = Color.White
        )
    }
}

@Composable
fun TextWithShadow(value: String) {
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        color = Color.Black,
        style = TextStyle(
            shadow = androidx.compose.ui.graphics.Shadow(
                color = ShadowColors.generateRandomColor(),
                offset = shadowOffset,
                blurRadius = 2f
            )
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithShadowPreview() {
    TextWithShadow(value = "Murad Najafli")
}

@Composable
fun FactComposable(
    value: String,
    changeQuote: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .clickable {
                changeQuote()
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp, 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.quote_icon),
                contentDescription = "Quote Icon",
                modifier = Modifier
                    .size(36.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextWithShadow(value = value)

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.quote_icon),
                contentDescription = "Quote Icon",
                modifier = Modifier
                    .size(36.dp)
                    .rotate(180f)
            )
        }
    }



}

@Preview
@Composable
fun FactComposablePreview() {
    FactComposable("Some car facts...", changeQuote = {})
}