package tech.example.task.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReaderDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertReader(reader: Reader)

    @Query("select * from Reader")
    fun getReader(): Flow<List<Reader>>

}

