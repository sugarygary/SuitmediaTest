package com.suitmedia.test.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.suitmedia.test.data.remote.response.UserResponse
import com.suitmedia.test.domain.model.User

interface IUserRepository {
    fun fetchUsers(): LiveData<PagingData<User>>
}