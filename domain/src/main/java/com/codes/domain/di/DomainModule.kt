package com.codes.domain.di

import com.codes.domain.repository.FollowersRepository
import com.codes.domain.repository.FollowingRepository
import com.codes.domain.repository.ReposRepository
import com.codes.domain.repository.UserRepository
import com.codes.domain.usecases.*
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
        repository: ReposRepository
    ): UserUseCase {
        return UserUseCase(
            userUseCase = GetUserUseCase(userRepository),
            followersUseCase = GetFollowersUseCase(followersRepository),
            followingUseCase = GetFollowingUseCase(followingRepository),
            repositoryUseCase = GetRepositoryUseCase(repository)
        )
    }
}