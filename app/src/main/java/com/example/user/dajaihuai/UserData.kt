package com.example.user.dajaihuai

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "app_name") var name: String?,
    @ColumnInfo(name = "account") var account: String?,
    @ColumnInfo(name = "password") var password: String?
)