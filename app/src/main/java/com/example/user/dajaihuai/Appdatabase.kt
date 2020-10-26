package com.example.user.dajaihuai

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [(UserData::class)], version = 1, exportSchema = false)
abstract class Appdatabase : RoomDatabase() {

    companion object {
        var INSTANCE: Appdatabase? = null

        fun getDataBase(context: Context,scope: CoroutineScope):Appdatabase{
            return INSTANCE ?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Appdatabase::class.java,
                    "app_database"
                )
                    .addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

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


    private class UserDatabaseCallback (
        private val scope:CoroutineScope
    ): RoomDatabase.Callback() {
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


//    companion object{
//        fun getDatabase(
//            context : Context,
//            scope: CoroutineScope
//        ):Appdatabase{
//        }
//    }
}