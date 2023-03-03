package com.codes.githubapp.data.repository.di

import com.codes.githubapp.data.cache.dao.UserDao
import com.codes.githubapp.data.cache.database.GithubDatabase
import com.codes.githubapp.data.remote.api.GithubApi
import com.codes.githubapp.data.repository.repository.FollowersRepositoryImpl
import com.codes.githubapp.data.repository.repository.FollowingRepositoryImpl
import com.codes.githubapp.data.repository.repository.UserRepoRepositoryImpl
import com.codes.githubapp.data.repository.repository.UserRepositoryImpl
import com.codes.githubapp.domain.repository.FollowersRepository
import com.codes.githubapp.domain.repository.FollowingRepository
import com.codes.githubapp.domain.repository.UserRepoRepository
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
    fun providesRepository(githubApi: GithubApi, database: GithubDatabase): UserRepoRepository {
        return UserRepoRepositoryImpl(githubApi, database.repositoriesDao())
    }

    @Singleton
    @Provides
    fun provideUserRepository(githubApi: GithubApi, database: GithubDatabase): UserRepository {
        return UserRepositoryImpl(githubApi, database.userDao())
    }

    @Singleton
    @Provides
    fun providesFollowingRepository(githubApi: GithubApi, database: GithubDatabase): FollowingRepository {
        return FollowingRepositoryImpl(githubApi, database.followingDao())
    }

    @Singleton
    @Provides
    fun providesFollowersRepository(githubApi: GithubApi, database: GithubDatabase): FollowersRepository {
        return FollowersRepositoryImpl(githubApi, database.followersDao())
    }
}