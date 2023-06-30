package com.github.simpleretrofitexampleapp.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.simpleretrofitexampleapp.ApplicationEntryPoint
import com.github.simpleretrofitexampleapp.domain.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainScreenViewModel(private val repository: Repository) : ViewModel() {


    var uiState: UIState by mutableStateOf(UIState.Loading)
        private set

    init {
        getPhotos()
    }


    fun getPhotos() {
        viewModelScope.launch {
            uiState = UIState.Loading
            uiState = try {
                UIState.Success(repository.getPhotos())
            } catch (e: IOException) {
                UIState.Error
            } catch (e: HttpException) {
                UIState.Error
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ApplicationEntryPoint)
                val repository = application.diContainer.repository
                MainScreenViewModel(repository = repository)
            }
        }
    }
}