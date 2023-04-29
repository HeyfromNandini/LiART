package tech.example.task.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [Reader::class], version = 1)
abstract class DatabaseObj: RoomDatabase(){
    abstract  fun readerDao() : ReaderDao
    companion object {
        @Volatile
        private var Instance : DatabaseObj?= null
        fun getInstance(context: Context): DatabaseObj {
            synchronized(this){
                if (Instance == null){
                    Instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseObj::class.java,
                        "ReaderDatabase"
                    ).build()
                }
            }
            return Instance!!
        }
    }

}

