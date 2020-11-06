package com.khan.baseclass.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.khan.baseclass.listener.ResponseListener

class HomeViewModel : ViewModel() {
    var responseListener: ResponseListener? = null

    fun onButtonClick(view: View) {
        responseListener?.onStarted()
    }
}