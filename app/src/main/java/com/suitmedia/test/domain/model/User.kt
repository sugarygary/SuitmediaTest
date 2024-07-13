package com.suitmedia.test.domain.model

import com.suitmedia.test.data.remote.response.UserResponse

data class User(

    val lastName: String,

    val id: Int,

    val avatar: String,

    val firstName: String,

    val email: String
) {
    constructor(userResponse: UserResponse) : this(
        lastName = userResponse.lastName,
        id = userResponse.id,
        avatar = userResponse.avatar,
        firstName = userResponse.firstName,
        email = userResponse.email
    )
}
