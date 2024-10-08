package uz.apphub.metan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import uz.apphub.metan.ui.theme.AnswerRed
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 9/14/2024
 **/
@Composable
fun ErrorDialogComponent(
    modifier: Modifier = Modifier,
    message: String = "Null",
    onDismiss: () -> Unit,
) {

    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.Transparent,
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
        ) {
            Column(
                modifier = modifier
                    .background(color = ItemBackground)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButtonComponent(
                        icon = Icons.Default.Close
                    ) {
                        onDismiss()
                    }
                }
                TextComponent(
                    text = message,
                    color = AnswerRed,
                    textAlign = TextAlign.Center,
                    paddingHorizontal = 0.dp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ErrorDialogComponentPreview() {
    ErrorDialogComponent(onDismiss = {})
}