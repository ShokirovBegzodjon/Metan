package uz.apphub.metan.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.apphub.metan.ui.theme.IconTint

/**
 * Created By Shokirov Begzod on 9/15/2024
 **/

@Composable
fun IconButtonComponent(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.MoreVert,
    contentDescription: String = "More",
    weight: Dp = 24.dp,
    tint: Color = IconTint,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .width(weight),
        onClick = { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun IconButtonComponentPreview() {
    IconButtonComponent(onClick = {})
}