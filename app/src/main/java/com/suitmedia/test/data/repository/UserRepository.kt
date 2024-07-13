package com.suitmedia.test.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.suitmedia.test.data.remote.service.ApiService
import com.suitmedia.test.domain.model.User
import com.suitmedia.test.domain.repository.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) : IUserRepository {
    override fun fetchUsers(): LiveData<PagingData<User>> {
        return Pager(
            initialKey = 1,
            config = PagingConfig(
                initialLoadSize = 4,
                pageSize = 4,
                enablePlaceholders = true,
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }
}