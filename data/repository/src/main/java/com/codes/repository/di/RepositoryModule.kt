package com.codes.repository.di

import com.codes.cache.database.GithubDatabase
import com.codes.domain.repository.FollowersRepository
import com.codes.domain.repository.FollowingRepository
import com.codes.domain.repository.UserRepository
import com.codes.repository.repository.FollowersRepositoryImpl
import com.codes.repository.repository.FollowingRepositoryImpl
import com.codes.repository.repository.UserRepoRepositoryImpl
import com.codes.repository.repository.UserRepositoryImpl
import com.codes.remote.api.GithubApi
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
    fun providesRepository(githubApi: GithubApi, database: GithubDatabase): UserRepoRepositoryImpl {
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