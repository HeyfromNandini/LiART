package tech.example.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import tech.example.task.database.DatabaseObj
import tech.example.task.database.DatabaseRepo
import tech.example.task.database.Reader




class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatabaseRepo
    val searchResult: Flow<List<Reader>>

    init {
        val dB = DatabaseObj.getInstance(context = application.applicationContext)
        val dataDao = dB.readerDao()
        repository = DatabaseRepo(dataDao)
        searchResult = repository.searchResults
    }

    fun String.insertReader(
        name: String,
        email: String,
        phoneValue: String,
        passwordValue: String
    ){
        viewModelScope.launch {
            repository.insertStudent(
                Reader(
                    name = name,
                    emailID = email,
                    passwordValue = passwordValue,
                    phoneValue = this@insertReader
                )
            )
        }
    }

    fun insertReader(name: String, email: String, phoneValue: String, passwordValue: String) {

    }
}