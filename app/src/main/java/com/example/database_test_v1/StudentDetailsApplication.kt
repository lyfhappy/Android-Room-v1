package com.example.database_test_v1

import android.app.Application
import com.example.database_test_v1.data.AppDatabase

class StudentDetailsApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
  //  val database: AppDatabase by lazy{AppDatabase.getDatabase(this)}
}
