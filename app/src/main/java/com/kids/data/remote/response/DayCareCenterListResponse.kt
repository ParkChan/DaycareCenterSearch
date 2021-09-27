package com.kids.data.remote.response

import com.kids.ui.main.model.DaycareCenterListModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DayCareCenterListResponse(

    @Json(name = "pageCnt")
    val pageCnt: Int? = null,

    @Json(name = "currentPage")
    val currentPage: Int? = null,

    @Json(name = "sidoList")
    val sidoList: String? = null,

    @Json(name = "sggList")
    val sggList: String? = null,

    @Json(name = "status")
    val status: String? = null,

    @Json(name = "kinderInfo")
    val daycareCenterList: List<DaycareCenterResponse>? = null
)

fun DayCareCenterListResponse.mapToModel() =
    DaycareCenterListModel(
        pageCnt = pageCnt ?: 0,
        currentPage = currentPage ?: 0,
        sidoList = sidoList ?: "",
        sggList = sggList ?: "",
        daycareCenterList = daycareCenterList?.map { it.mapToModel() } ?: emptyList()
    )