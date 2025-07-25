package com.example.routetask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routetask.data.utils.ApiResult
import com.example.routetask.domain.contract.repository.PhotosRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ActivityViewModel @Inject constructor(
    val photosRepository:PhotosRepo
): ViewModel() {

    private var _uiState = MutableStateFlow<UiState>(UiState.Ideal)
    val uiState = _uiState

    fun getPhotos(){
        viewModelScope.launch(Dispatchers.IO) {
            photosRepository.getPhotos().collect {apiResult->
                when(apiResult){
                    is ApiResult.Error -> {
                        _uiState.update { UiState.Error(apiResult.error)}
                        }
                    is ApiResult.Loading -> {
                        _uiState.update {  UiState.Loading}
                    }
                    is ApiResult.Success -> {
                        _uiState.update {  UiState.Success(apiResult.response)}
                    }
                }
            }
        }
    }
}