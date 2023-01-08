package com.example.androidtutorial.roomdb.repo

import com.example.androidtutorial.roomdb.User
import com.example.androidtutorial.roomdb.UserDao

class UserRepoImpl(private val userDao: UserDao) : UserRepo {
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun getAllUser(): List<User> {
        return userDao.getAll()
    }
}
