package com.kids.data.response

import com.kids.ui.main.model.DaycareCenterListModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DaycareCenterListResponse(

    @field:Json(name = "pageCnt")
    val pageCnt: Int? = null,

    @field:Json(name = "currentPage")
    val currentPage: Int? = null,

    @field:Json(name = "sidoList")
    val sidoList: String? = null,

    @field:Json(name = "sggList")
    val sggList: String? = null,

    @field:Json(name = "status")
    val status: String? = null,

    @field:Json(name = "kinderInfo")
    val daycareCenterList: List<DaycareCenterResponse>? = null
)

fun DaycareCenterListResponse.mapToModel() =
    DaycareCenterListModel(
        pageCnt = pageCnt ?: 0,
        currentPage = currentPage ?: 0,
        sidoList = sidoList ?: "",
        sggList = sggList ?: "",
        daycareCenterList = daycareCenterList?.map { it.mapToModel() } ?: emptyList()
    )