package uz.apphub.metan.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.apphub.metan.ui.theme.ButtonBackground

/**
 * Created By Shokirov Begzod on 8/17/2024
 **/
@Composable
fun ButtonComponent(
    text: String = "Keyingi",
    onClickButton: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            )
            .height(50.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(ButtonBackground),
        onClick = { onClickButton() }
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun ButtonComponentPreview() {
    ButtonComponent() {}
}