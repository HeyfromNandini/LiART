package tech.example.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import tech.example.task.database.DatabaseObj
import tech.example.task.database.DatabaseRepo
import tech.example.task.database.Student



class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatabaseRepo
    val searchResult: Flow<List<Student>>

    init {
        val dB = DatabaseObj.getInstance(context = application.applicationContext)
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