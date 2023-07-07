package com.mastercoding.library.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BookDao {
    @Insert
   suspend fun addBook(bookEntity: BookEntity)


}