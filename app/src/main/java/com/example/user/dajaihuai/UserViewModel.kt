package com.example.user.dajaihuai

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository : UserRepository = TODO()
    val allUser : LiveData<List<UserData>>

    init {
        val userDao = Appdatabase.buildDatabase(application).getUsersDao()
        repository = UserRepository(userDao)
        allUser = repository.allUsers
    }
    fun insert(user:UserData) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(user)
    } 

}