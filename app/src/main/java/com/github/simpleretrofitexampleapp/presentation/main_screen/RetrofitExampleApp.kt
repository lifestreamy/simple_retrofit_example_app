package com.github.simpleretrofitexampleapp.presentation.main_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.simpleretrofitexampleapp.presentation.main_screen.components.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RetrofitExampleApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val mainScreenViewModel: MainScreenViewModel =
                viewModel(factory = MainScreenViewModel.Factory)
            MainScreen(
                uiState = mainScreenViewModel.uiState,
                retryAction = mainScreenViewModel::getPhotos
            )
        }
    }
}

