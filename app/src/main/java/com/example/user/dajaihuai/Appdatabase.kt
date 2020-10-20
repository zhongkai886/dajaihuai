package com.example.user.dajaihuai

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(UserData::class)], version = 1, exportSchema = false)
abstract class Appdatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "123.db"
        @Volatile private var instance: Appdatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            Appdatabase::class.java, DATABASE_NAME).build()
    }

    abstract fun getUsersDao(): UserDao
}