package tech.example.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatabaseRepo
    val searchResult: Flow<List<Student>>

    init {
        val dB = DatabaseObj
        val dataDao = dB.studentDao()
        repository = DatabaseRepo(dataDao)
        searchResult = repository.searchResults
    }

    fun insertStudent(
        name: String,
        email: String,
        phoneValue:String
    ){
        viewModelScope.launch {
            repository.insertStudent(
                Student(
                    name = name,
                    emailID = email,
                    phoneValue = phoneValue
                )
            )
        }
    }
}