package uz.apphub.metan.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.apphub.metan.R
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 8/15/2024
 **/
@Composable
fun PasswordTextFieldComponent(
    value: String,
    placeholder: String = "Parolni kiriting",
    singleLine: Boolean = true,
    textColor: Color = Color.Black,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.password_visibility)
    } else {
        painterResource(id = R.drawable.password_invisibility)
    }
    TextField(
        colors = TextFieldDefaults.colors(
            cursorColor = textColor,
            disabledContainerColor = ItemBackground,
            focusedContainerColor = ItemBackground,
            unfocusedContainerColor = ItemBackground,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            errorTextColor = Color.Red,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        value = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            ),
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text(
                color = textColor,
                text = placeholder
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = icon,
                    contentDescription = "Visibility icon"
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        singleLine = singleLine

    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun PasswordTextFieldComponentPreview() {
    PasswordTextFieldComponent(value = "", onValueChange = {})
}