package uz.apphub.metan.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.apphub.metan.R

/**
 * Created By Shokirov Begzod on 9/12/2024
 **/
@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ImageComponentPreview() {
    ImageComponent(
        image = painterResource(R.drawable.icons_truck),
        contentDescription = "Matematika"
    )
}