package uz.apphub.metan.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.apphub.metan.ui.theme.IconTint
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 8/17/2024
 **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    showBackIcon: Boolean = true,
    background: Color = ItemBackground,
    textColor: Color = Color.Black,
    iconTint: Color = IconTint,
    startIcon: ImageVector = Icons.Default.KeyboardArrowLeft,
    endIcon: ImageVector? = null,
    onBackClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(background),
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp),
        navigationIcon = {
            if (showBackIcon) {
                IconButton(
                    onClick = { onBackClick() },
                ) {
                    Image(
                        imageVector = startIcon,
                        contentDescription = "Back icon",
                        colorFilter = ColorFilter.tint(iconTint)
                    )
                }
            }
        },
        title = {
            Row {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 16.dp
                        )
                        .weight(1F),
                    color = textColor,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (endIcon!= null) {
                    IconButton(
                        onClick = {},
                    ) {
                        Image(
                            imageVector = endIcon,
                            contentDescription = "More icon",
                            colorFilter = ColorFilter.tint(iconTint)
                        )
                    }
                }
            }
        })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewTopBarComponent() {
    TopBarComponent(
        text = "Fanlardantkwelj rkgbjslkfdwk;nlf jkbsdok'ef pwjgutestlar",
        onBackClick = {}
    )
}