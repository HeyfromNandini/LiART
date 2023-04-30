package tech.example.task.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [Reader::class], version = 1)
abstract class Database: RoomDatabase(){
    abstract  fun readerDao() : ReaderDao
    companion object {
        @Volatile
        private var Instance : Database ?= null
        fun getInstance(context: Context): Database{
            synchronized(this){
                if (Instance == null){
                    Instance = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "ReaderDatabase"
                    ).build()
                }
            }
            return Instance!!
        }
    }

}


