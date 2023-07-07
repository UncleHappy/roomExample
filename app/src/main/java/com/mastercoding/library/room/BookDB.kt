package com.mastercoding.library.room


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BookDB : RoomDatabase() {
    abstract fun bookDao(): BookDao
    companion object {
        @Volatile
        private var INSTANCE: BookDB? = null


       fun getInstance(context:android.content.Context): BookDB {
           synchronized(this) {
               var instance = INSTANCE
               if(instance == null){
                   instance = Room.databaseBuilder(
                       context.applicationContext,
                       BookDB::class.java,
                       name = "books_db"
                       ).build()
                   instance=instance
               }
                   return instance

           }

       }
    }
}