package tech.example.task.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reader")
data class Reader(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phoneValue")
    val phoneValue : String,
    @ColumnInfo(name = "passwordValue")
    val passwordValue : String,
    @PrimaryKey
    @ColumnInfo(name = "emailID")
    val emailID: String,
)