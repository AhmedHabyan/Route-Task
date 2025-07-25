package com.example.routetask.presentation

import com.example.routetask.data.Entity.PhotoResponse
import com.example.routetask.domain.model.Photo

sealed class UiState(){
    object Ideal:UiState()
    object Loading:UiState()
    data class Success(val response: Photo):UiState()
    data class Error(val exception: Exception):UiState()
}