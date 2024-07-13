package com.suitmedia.test.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.suitmedia.test.data.remote.response.UserResponse
import com.suitmedia.test.data.remote.service.ApiService
import com.suitmedia.test.domain.model.User

class UserPagingSource(private val apiService: ApiService) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getUsers(position, params.loadSize)
            val dto = responseData.data.map {
                User(it)
            }
            LoadResult.Page(
                data = dto,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.data.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            Log.e("UserPagingSource", "Error: ${exception.message}")
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}