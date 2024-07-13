package com.suitmedia.test.di

import com.suitmedia.test.data.repository.UserRepository
import com.suitmedia.test.domain.repository.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository
}