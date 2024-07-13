package com.suitmedia.test.di

import com.suitmedia.test.data.repository.UserRepository
import com.suitmedia.test.domain.usecase.FetchUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideFetchUsersUseCase(userRepository: UserRepository): FetchUsersUseCase {
        return FetchUsersUseCase(userRepository)
    }
}