package com.github.simpleretrofitexampleapp.presentation.main_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.simpleretrofitexampleapp.presentation.main_screen.component_screens.ErrorScreen
import com.github.simpleretrofitexampleapp.presentation.main_screen.component_screens.LoadingScreen
import com.github.simpleretrofitexampleapp.presentation.main_screen.component_screens.PhotosGridScreen

@Composable
fun MainScreen(
    uiState: UIState, retryAction: () -> Unit, modifier: Modifier = Modifier
) {
    when (uiState) {
        is UIState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is UIState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
        is UIState.Success -> PhotosGridScreen(
           uiState.photos, modifier = modifier.fillMaxWidth()
        )
    }
}

