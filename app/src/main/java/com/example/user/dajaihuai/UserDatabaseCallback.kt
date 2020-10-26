package com.example.user.dajaihuai

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KParameter

class UserDatabaseCallback (private val scope:CoroutineScope): RoomDatabase.Callback() {
    var INSTANCE = Appdatabase.INSTANCE

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        INSTANCE?.let{ database ->
            scope.launch {
                populateDatabase(database.getUsersDao())
            }
        }
    }

    suspend fun populateDatabase(userDao: UserDao){
//        userDao.deleteAll()

        var user = UserData(25,"aaa","bbb","ccc")
        userDao.insert(user)
        user = UserData(50,"aaa","bbb","ccc")
        userDao.insert(user)
    }
}