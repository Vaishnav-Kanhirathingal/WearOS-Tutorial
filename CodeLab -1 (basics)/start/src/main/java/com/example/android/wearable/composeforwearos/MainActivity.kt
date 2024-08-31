package com.example.android.wearable.composeforwearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.example.android.wearable.composeforwearos.theme.WearAppTheme
import com.google.android.horologist.annotations.ExperimentalHorologistApi

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
        /* *************************** Part 4: Wear OS Scaffold *************************** */
        // TODO (Start): Create a AppScaffold (Wear Version)

        // TODO: Swap to ScalingLazyColumnState
        val listState = rememberLazyListState()

        /* *************************** Part 4: Wear OS Scaffold *************************** */
        // TODO (Start): Create a ScreenScaffold (Wear Version)

        // Modifiers used by our Wear composables.
        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
        val iconModifier = Modifier
            .size(24.dp)
            .wrapContentSize(align = Alignment.Center)

        /* *************************** Part 3: ScalingLazyColumn *************************** */
        // TODO: Swap a ScalingLazyColumn (Wear's version of LazyColumn)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = 32.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 32.dp,
            ),
            verticalArrangement = Arrangement.Center,
            state = listState,
        ) {
            // TODO: Remove item; for beginning only.
            item { StartOnlyTextComposables() }

            /* ******************* Part 1: Simple composables ******************* */
            item { ButtonExample(contentModifier, iconModifier) }
            item { TextExample(contentModifier) }
            item { CardExample(contentModifier, iconModifier) }

            /* ********************* Part 2: Wear unique composables ********************* */
            item { ChipExample(contentModifier, iconModifier) }
            item { ToggleChipExample(contentModifier) }
        }

        // TODO (End): Create a ScreenScaffold (Wear Version)
    }
    // TODO (End): Create a AppScaffold (Wear Version)
}

@WearPreviewDevices
@Composable
fun WearAppPreview() {
    WearApp()
}
