package tech.example.task.database

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DatabaseRepo (private val readerDao: ReaderDao){
    val searchResults: Flow<List<Reader>> = readerDao.getReader()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    fun insertReader(reader: Reader){
        coroutineScope.launch {
            readerDao.insertReader(reader)
        }
    }
}
