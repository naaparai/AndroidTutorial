package com.example.androidtutorial.roomdb.di

import android.content.Context
import androidx.room.Room
import com.example.androidtutorial.roomdb.AppDatabase
import com.example.androidtutorial.roomdb.UserDao
import com.example.androidtutorial.roomdb.repo.UserRepo
import com.example.androidtutorial.roomdb.repo.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {

    @Provides
    fun provideUserRepo(userDao: UserDao): UserRepo {
        return UserRepoImpl(userDao)
    }

    @Provides
    fun provideUserDao(@ApplicationContext context: Context): UserDao {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database-name"
        ).build()
        return db.userDao()
    }
}
