package com.example.database_test_v1.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(studentDetailsTable: StudentDetailsTable)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Update(studentDetailsTable: StudentDetailsTable)
     @Delete
     suspend fun delete(studentDetailsTable: StudentDetailsTable)

     @Query("Select * from student_table_v2 ORDER BY name ASC")
     fun getAllStudents(): Flow<List<StudentDetailsTable>>

     @Query("Select * from student_table_v2 Where id= :id")
     fun getStudentsbyid(id:Int):Flow<StudentDetailsTable>

/*
    @Query("Select * From student_table Where name Like '%name%'")
    fun SearchStudentbyName(name:String):Flow<List<StudentDetailsTable>>
    */

}