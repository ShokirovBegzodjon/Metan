 package uz.apphub.metan.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created By Shokirov Begzod on 8/15/2024
 **/
@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontFamily: FontFamily = FontFamily.Default,
    fontWeight: FontWeight = FontWeight.Normal,
    lineHeight: TextUnit = 16.sp,
    paddingHorizontal: Dp = 16.dp,
) {
    Text(
        text = text,
        textAlign = textAlign,
        modifier = modifier
            .padding(
                vertical = 0.dp,
                horizontal = paddingHorizontal),
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontFamily = fontFamily,
        lineHeight = lineHeight
    )
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun PreviewTextComponent() {
    TextComponent(text = "Hello, Woradefsdnvklfajsdkbhvjdiemfaldskhbefaljkdsbhvnjedlajvkhdld!")
}