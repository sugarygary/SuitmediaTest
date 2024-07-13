package com.suitmedia.test.data.remote.response

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class GetUserResponse(

    @Json(name = "per_page")
    val perPage: Int,

    @Json(name = "total")
    val total: Int,

    @Json(name = "data")
    val data: List<UserResponse>,

    @Json(name = "page")
    val page: Int,

    @Json(name = "total_pages")
    val totalPages: Int,

    @Json(name = "support")
    val support: Support
)

@JsonClass(generateAdapter = true)
data class Support(

    @Json(name = "text")
    val text: String,

    @Json(name = "url")
    val url: String
)

@JsonClass(generateAdapter = true)
data class UserResponse(

    @Json(name = "last_name")
    val lastName: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "avatar")
    val avatar: String,

    @Json(name = "first_name")
    val firstName: String,

    @Json(name = "email")
    val email: String
)
