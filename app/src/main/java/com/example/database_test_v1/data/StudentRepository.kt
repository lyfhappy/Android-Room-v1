package com.example.database_test_v1.data

import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun addStudent(studentDetailsTable: StudentDetailsTable){
        studentDao.Insert(studentDetailsTable)
    }

    suspend fun updateStudent(studentDetailsTable: StudentDetailsTable){
        studentDao.Update(studentDetailsTable)
    }

    suspend fun deleteStudents(studentDetailsTable: StudentDetailsTable){
        studentDao.delete(studentDetailsTable)
    }

    val getAllStudents :Flow<List<StudentDetailsTable>> = studentDao.getAllStudents()
    fun getStudentsbyid(id:Int):Flow<StudentDetailsTable> = studentDao.getStudentsbyid(id)

}