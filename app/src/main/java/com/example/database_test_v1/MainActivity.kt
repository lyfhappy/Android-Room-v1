package com.example.database_test_v1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.database_test_v1.data.AppDatabase
import com.example.database_test_v1.data.StudentDetailsTable
import com.example.database_test_v1.data.StudentRepository
import com.example.database_test_v1.model.StudentViewModel

class MainActivity : ComponentActivity() {

   val viewModel: StudentViewModel by lazy {
       ViewModelProvider(
           this,
         factory = StudentViewModel.factory
       ).get(StudentViewModel::class.java)
   }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                // Top Level Declaration
             studentDataEntry(viewModel)

        }
    }
}
@SuppressLint("UnrememberedMutableState")
@Composable
fun studentDataEntry(viewModel: StudentViewModel) {
    var id:Int = 0
    var studentNameState by remember{mutableStateOf("")}
    var studentmobilState by remember {mutableStateOf("") }

 //   val viewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
        OutlinedTextField(
            value = studentNameState,
            onValueChange = { studentNameState = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardActions = KeyboardActions.Default,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))

        OutlinedTextField(
            value = studentmobilState,
            onValueChange = { studentmobilState = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardActions = KeyboardActions.Default,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
        )

    Spacer(modifier = Modifier.padding(10.dp))
       Button(onClick = { viewModel.insert(StudentDetailsTable(id,studentNameState,studentmobilState,studentmobilState))}) {
           Text(text = "Submit")
       }
        }
}



@Preview
@Composable
fun studentDataEntryPreview(){
   // studentDataEntry(v)
}