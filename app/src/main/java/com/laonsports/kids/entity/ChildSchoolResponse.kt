package com.laonsports.kids.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChildSchoolResponse(
    @field:Json(name = "code")
    val code: Int? = null
)

