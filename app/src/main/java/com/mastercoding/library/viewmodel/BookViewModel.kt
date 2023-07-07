package com.mastercoding.library.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mastercoding.library.repository.Repository
import com.mastercoding.library.room.BookEntity
import kotlinx.coroutines.launch

class BookViewModel(val repository: Repository): ViewModel() {
    fun addBook(book: BookEntity) {
        viewModelScope.launch { repository.addBooksToRoom(book) }

    }

}