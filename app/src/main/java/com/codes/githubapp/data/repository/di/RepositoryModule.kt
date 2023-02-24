package com.codes.githubapp.data.repository.di

import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.repository.UserRepositoryImpl
import com.codes.githubapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(githubApi: GithubApi): UserRepository {
        return UserRepositoryImpl(githubApi = githubApi)
    }
}