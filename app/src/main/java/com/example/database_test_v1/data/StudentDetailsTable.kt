package com.example.database_test_v1.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table_v2")
data class StudentDetailsTable(
   @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    @ColumnInfo(name = "Name")
    val name:String,
    @ColumnInfo(name = "Mobile Number")
    val mobileNum:String,
    @ColumnInfo(name = "Course")
    val course:String
)