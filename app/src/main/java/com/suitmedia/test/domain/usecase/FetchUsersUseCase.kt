package com.suitmedia.test.domain.usecase

import com.suitmedia.test.data.repository.UserRepository

class FetchUsersUseCase(private val userRepository: UserRepository) {
    fun execute() = userRepository.fetchUsers()
}