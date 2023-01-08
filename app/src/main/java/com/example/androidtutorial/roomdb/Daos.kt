package com.example.androidtutorial.roomdb

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    fun delete(user: User)
}

@Dao
interface AdminDao {
    @Query("SELECT * FROM admin")
    suspend fun getAll(): List<Admin>

    @Insert
    suspend fun insertUser(user: Admin)

    @Delete
    fun delete(admin: Admin)
}

@Database(entities = [User::class, Admin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun adminDao(): AdminDao
}
