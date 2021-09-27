package com.kids.data.remote.source

import com.kids.data.remote.response.DayCareCenterListResponse
import retrofit2.Response

interface CenterListDataSource {

    suspend fun getDayCareCenters(
        key: String,
        currentPage: Int,
        pageCount: Int,
        sidoCode: String,
        sggCode: String
    ): Response<DayCareCenterListResponse>
}