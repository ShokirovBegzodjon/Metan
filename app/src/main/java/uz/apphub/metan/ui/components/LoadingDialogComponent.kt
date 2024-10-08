package uz.apphub.metan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import uz.apphub.metan.ui.theme.AnswerBlue
import uz.apphub.metan.ui.theme.AnswerRed
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 9/14/2024
 **/
@Composable
fun LoadingDialogComponent(
    modifier: Modifier = Modifier,
    text: String = "",
) {

    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = modifier
                .padding(16.dp),
            color = Color.Transparent,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = modifier
                    .background(color = ItemBackground),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator(
                    modifier
                        .padding(16.dp)
                        .size(48.dp),
                    color = AnswerBlue
                )

                if (text.isNotEmpty()){
                    TextComponent(
                        text = text,
                        color = AnswerRed,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun LoadingDialogComponentPreview() {
    LoadingDialogComponent()
}