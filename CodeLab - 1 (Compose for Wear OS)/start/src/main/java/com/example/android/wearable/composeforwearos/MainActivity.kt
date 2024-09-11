package com.example.android.wearable.composeforwearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.example.android.wearable.composeforwearos.theme.WearAppTheme
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.AppScaffold
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun WearApp() {
    WearAppTheme {
        AppScaffold(
            content = {
                val listState = rememberResponsiveColumnState(
                    contentPadding = ScalingLazyColumnDefaults.padding(
                        first = ScalingLazyColumnDefaults.ItemType.SingleButton,
                        last = ScalingLazyColumnDefaults.ItemType.Chip
                    )
                )
                ScreenScaffold(
                    scrollState = listState,
                    content = {
                        val contentModifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        val iconModifier = Modifier
                            .size(24.dp)
                            .wrapContentSize(align = Alignment.Center)
                        ScalingLazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            columnState = listState,
                        ) {
                            item { ButtonExample(contentModifier, iconModifier) }
                            item { TextExample(contentModifier) }
                            item { CardExample(contentModifier, iconModifier) }

                            item { ChipExample(contentModifier, iconModifier) }
                            item { ToggleChipExample(contentModifier) }
                        }
                    }
                )
            }
        )
    }
}

@WearPreviewDevices
@Composable
fun WearAppPreview() {
    WearApp()
}
