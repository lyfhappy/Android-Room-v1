package com.example.database_test_v1.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.database_test_v1.MainActivity
import com.example.database_test_v1.StudentDetailsApplication
import com.example.database_test_v1.data.AppDatabase
import com.example.database_test_v1.data.StudentDao
import com.example.database_test_v1.data.StudentDetailsTable
import com.example.database_test_v1.data.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class StudentViewModel(private val studentRepository: StudentRepository):ViewModel() {

    lateinit var getAllStudents: Flow<List<StudentDetailsTable>>

    init {
        viewModelScope.launch {
            getAllStudents = studentRepository.getAllStudents
        }
    }


    fun insert(studentDetailsTable: StudentDetailsTable) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.addStudent(studentDetailsTable)
        }
    }

    fun update(studentDetailsTable: StudentDetailsTable) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.updateStudent(studentDetailsTable)
        }
    }

    fun delete(studentDetailsTable: StudentDetailsTable) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.deleteStudents(studentDetailsTable)
        }
    }

    fun getAllStudents(): Flow<List<StudentDetailsTable>> {
        return studentRepository.getAllStudents
    }

    fun getStudentsbyid(id: Int): Flow<StudentDetailsTable> {
        return studentRepository.getStudentsbyid(id)
    }

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as StudentDetailsApplication)
                StudentViewModel(application.container.itemsRepository)
            }
        }
    }

}
//    fun SearchStudentbyName(name:String):Flow<List<StudentDetailsTable>> { return studentdao.SearchStudentbyName(name) }

