package uz.apphub.metan.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.apphub.metan.R
import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.FuelStatus
import uz.apphub.metan.data.model.home.VehicleType
import uz.apphub.metan.ui.components.ImageComponent
import uz.apphub.metan.ui.components.TextComponent
import uz.apphub.metan.ui.theme.AnswerGreen
import uz.apphub.metan.ui.theme.AnswerRed
import uz.apphub.metan.ui.theme.ItemBackground

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
@Composable
fun HomeItem(
    fuelModel: FuelModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(
                color = when (fuelModel.fuelStatus) {
                    FuelStatus.CLOSED -> AnswerRed
                    FuelStatus.OPEN -> AnswerGreen
                    FuelStatus.OTHER -> ItemBackground
                },
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        TextComponent(
            modifier = modifier.padding(top = 16.dp),
            text = fuelModel.name,
            fontWeight = FontWeight.Medium
        )
        TextComponent(
            text = fuelModel.fuelStatus.name,
        )
        Row(
            modifier = modifier
               .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            fuelModel.vehicleList.forEach { vehicle ->
                Column(
                    modifier = modifier
                        .widthIn(min = 100.dp)
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageComponent(
                        modifier = modifier,
                        image = vehicleTypeOfImage(vehicle.name),
                        contentDescription = vehicle.name.name
                    )
                    TextComponent(
                        modifier = modifier.fillMaxWidth(),
                        text = "${vehicle.count} ta",
                        paddingHorizontal = 0.dp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}

@Composable
private fun vehicleTypeOfImage(vehicleType: VehicleType): Painter {
    return when (vehicleType) {
        VehicleType.CAR -> painterResource(id = R.drawable.icons_car)
        VehicleType.TRUCK -> painterResource(id = R.drawable.icons_truck)
        VehicleType.BUS -> painterResource(id = R.drawable.icons_bus)
        VehicleType.OTHERS -> painterResource(id = R.drawable.ic_launcher_foreground)
    }
}