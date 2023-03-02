package com.codes.githubapp.domain.di

import com.codes.githubapp.domain.repository.FollowersRepository
import com.codes.githubapp.domain.repository.FollowingRepository
import com.codes.githubapp.domain.repository.UserRepoRepository
import com.codes.githubapp.domain.repository.UserRepository
import com.codes.githubapp.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideUseCases(
        userRepository: UserRepository,
        followersRepository: FollowersRepository,
        followingRepository: FollowingRepository,
        repository: UserRepoRepository
    ): UserUseCase {
        return UserUseCase(
            userUseCase = GetUserUseCase(userRepository),
            followersUseCase = GetFollowersUseCase(followersRepository),
            followingUseCase = GetFollowingUseCase(followingRepository),
            repositoryUseCase = GetRepositoryUseCase(repository)
        )
    }
}