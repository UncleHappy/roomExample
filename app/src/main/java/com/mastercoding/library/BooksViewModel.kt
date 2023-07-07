package com.mastercoding.library

import androidx.lifecycle.ViewModel
import com.mastercoding.library.repository.Repository
import com.mastercoding.library.room.BookEntity
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel(val repository: Repository) : ViewModel() {
    fun addBook(book: BookEntity) {
        viewModelScope.launch { repository.addBooksToRoom(book) }

    }
}
