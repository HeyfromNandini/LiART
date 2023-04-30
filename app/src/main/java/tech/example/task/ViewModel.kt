package tech.example.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import tech.example.task.database.Database

import tech.example.task.database.DatabaseRepo
import tech.example.task.database.Reader




class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatabaseRepo
    val searchResult: Flow<List<Reader>>

    init {
        val dB = Database.getInstance(application.applicationContext)
        val dataDao = dB.readerDao()
        repository = DatabaseRepo(dataDao)
        searchResult = repository.searchResults
    }

    fun insertReader(
        name: String,
        email: String,
        phoneValue:String,
        passwordValue:String
    ){
        viewModelScope.launch {
            repository.insertReader(
               Reader(
                    name = name,
                    emailID = email,
                    phoneValue = phoneValue,
                   passwordValue = passwordValue
                )
            )
        }
    }
}