package com.mastercoding.library.repository

import com.mastercoding.library.room.BookDB
import com.mastercoding.library.room.BookEntity



class Repository(val booksDB: BookDB) {

    suspend fun addBooksToRoom(bookEntity: BookEntity){
        booksDB.bookDao().addBook(bookEntity)

    }
}