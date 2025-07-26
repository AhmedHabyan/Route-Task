package com.example.routetask.presentation.utils

import android.opengl.Visibility
import android.view.View
import androidx.core.view.isVisible

fun View.setVisiblity(){
    isVisible= true

}

fun View.clear(){
    isVisible= false
}