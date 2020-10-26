package com.example.user.dajaihuai

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserData>

    @Query("SELECT * from users ORDER BY app_name ASC")
    fun getAllUser(): LiveData<List<UserData>>

    @Query("SELECT * FROM users WHERE app_name IN (:userApp)")
    fun loadAllByIds(userApp: Array<String>): List<UserData>

    @Query("SELECT * FROM users WHERE app_name LIKE :first AND " +
            "account LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserData

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: UserData?)

    @Insert
    fun insert(user: UserData?)

    @Delete
    fun delete(user: UserData?)

//    @Query("DELETE FROM users")
//    suspend fun deleteAll()
}
