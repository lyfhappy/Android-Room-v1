package com.example.database_test_v1

import android.content.Context
import com.example.database_test_v1.data.AppDatabase
import com.example.database_test_v1.data.StudentRepository

interface AppContainer {
    val itemsRepository: StudentRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: StudentRepository by lazy {
        StudentRepository(AppDatabase.getDatabase(context).studentdao())
    }
}