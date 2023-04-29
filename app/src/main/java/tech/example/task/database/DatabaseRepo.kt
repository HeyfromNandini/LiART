package tech.example.task.database

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DatabaseRepo (private val studentDao: StudentDao){
    val searchResults: Flow<List<Student>> = studentDao.getStudent()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    fun insertStudent(student: Student){
        coroutineScope.launch {
            studentDao.insertStudent(student)
        }
    }
}
