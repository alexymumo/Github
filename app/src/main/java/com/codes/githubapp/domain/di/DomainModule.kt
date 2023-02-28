package com.codes.githubapp.domain.di

import com.codes.githubapp.domain.repository.UserRepository
import com.codes.githubapp.domain.usecases.GetUserUseCase
import com.codes.githubapp.domain.usecases.UserUseCase
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
    fun provideUseCases(userRepository: UserRepository): UserUseCase {
        return UserUseCase(userUseCase = GetUserUseCase(userRepository))
    }
}