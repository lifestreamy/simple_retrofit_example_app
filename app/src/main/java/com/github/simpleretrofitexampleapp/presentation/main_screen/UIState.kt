package com.github.simpleretrofitexampleapp.presentation.main_screen

import com.github.simpleretrofitexampleapp.domain.model.Photo

sealed class UIState{

    object Loading : UIState()

    data class Success(val photos: List<Photo>) : UIState()

    object Error : UIState()

}
