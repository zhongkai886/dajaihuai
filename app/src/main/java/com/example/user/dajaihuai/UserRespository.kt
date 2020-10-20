package com.example.user.dajaihuai

import androidx.lifecycle.LiveData

class UserRepository(private val userDao:UserDao) {
    val allUsers:LiveData<List<UserData>> = userDao.getAllUser()
    suspend fun insert(user:UserData){
        userDao.insert(user)
    }
}