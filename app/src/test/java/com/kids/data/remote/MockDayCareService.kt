package com.kids.data.remote

import com.kids.data.remote.response.DayCareCenterListResponse
import com.kids.data.remote.source.DayCareCenterService
import kotlinx.coroutines.delay
import retrofit2.Response

object MockDayCareService : DayCareCenterService {
    override suspend fun getDayCareCenters(
        key: String,
        currentPage: Int,
        pageCount: Int,
        sidoCode: String,
        sggCode: String
    ): Response<DayCareCenterListResponse> {
        delay(reposDelay)
        return Response.success(testRepos)
    }
}