package com.codes.githubapp.data.cache.di

import android.content.Context
import androidx.room.Room
import com.codes.githubapp.data.cache.database.GithubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): GithubDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            GithubDatabase::class.java,
            "github.db"
        ).build()
    }
}