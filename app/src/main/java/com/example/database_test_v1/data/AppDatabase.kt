package com.example.database_test_v1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentDetailsTable::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentdao(): StudentDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database_v4"
                )
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}