package com.example.user.dajaihuai

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "app_name") val name: String,
    @ColumnInfo(name = "account") val account: String,
    @ColumnInfo(name = "password") val password: String
)