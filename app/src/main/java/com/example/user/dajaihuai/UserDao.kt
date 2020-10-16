package com.example.user.dajaihuai

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserData>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserData>

    @Query("SELECT * FROM users WHERE app_name LIKE :first AND " +
            "account LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserData

    @Insert
    fun insertAll(vararg users: UserData?)

    @Insert
    fun insert(user: UserData?)

    @Delete
    fun delete(user: UserData?)
}
