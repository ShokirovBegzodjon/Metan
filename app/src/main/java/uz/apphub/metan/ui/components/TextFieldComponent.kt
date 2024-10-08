package uz.apphub.metan.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 8/15/2024
 **/
@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    shape: Shape = RoundedCornerShape(8.dp),
    textColor: Color = Color.Black,
    backgroundColor: Color = ItemBackground,
    enabled: Boolean = true,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        shape = shape,
        colors = TextFieldDefaults.colors(
            cursorColor = textColor,
            disabledContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            errorTextColor = Color.Red,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = value,
        modifier = modifier
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
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        singleLine = singleLine,
        enabled = enabled

    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TextFieldComponentPreview() {
    TextFieldComponent(value = "", onValueChange = {})
}