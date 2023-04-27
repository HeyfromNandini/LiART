package tech.example.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OneShotOperationViewModel : ViewModel() {

        private val _toastMessage = MutableSharedFlow<String>()
        val toastMessage = _toastMessage.asSharedFlow()

        fun sendMessage(message: String) {
            viewModelScope.launch {
                _toastMessage.emit(message)
            }
        }
    }

