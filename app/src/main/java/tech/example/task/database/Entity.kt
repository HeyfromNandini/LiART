package tech.example.task.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phoneValue")
    val phoneValue : String,
    @PrimaryKey
    @ColumnInfo(name = "emailID")
    val emailID: String,
)