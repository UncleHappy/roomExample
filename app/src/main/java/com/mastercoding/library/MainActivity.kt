package com.mastercoding.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mastercoding.library.repository.Repository
import com.mastercoding.library.room.BookDB
import com.mastercoding.library.room.BookEntity
import com.mastercoding.library.ui.theme.LibraryTheme
import com.mastercoding.library.viewmodel.BookViewModel


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mContext = LocalContext.current
                    val db = BookDB.getInstance(mContext)
                    val repository = Repository(db)
                    val myViewModel =BooksViewModel(repository = repository)
                   MainScreen(myViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: BooksViewModel){

    var inputBook by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = inputBook,
            onValueChange = {
                enteredText -> inputBook = enteredText
            },
            label = { Text(text = "Book Name") },
            placeholder = { Text(text = "Enter Your Book Name") }
        )
        Button(onClick = {
       viewModel.addBook(BookEntity(0, inputBook))
        }){
            Text(text ="Insert Book into Database" )
            
        }

    }
}


