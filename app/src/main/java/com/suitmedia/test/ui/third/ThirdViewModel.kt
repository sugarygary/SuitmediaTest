package com.suitmedia.test.ui.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.suitmedia.test.domain.model.User
import com.suitmedia.test.domain.usecase.FetchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(private val fetchUsersUseCase: FetchUsersUseCase) :
    ViewModel() {
    private val _users = MutableLiveData<PagingData<User>>()
    val users: LiveData<PagingData<User>>
        get() = _users

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            fetchUsersUseCase.execute().cachedIn(viewModelScope).asFlow().collect{
                _users.value = it
            }
        }
    }
}