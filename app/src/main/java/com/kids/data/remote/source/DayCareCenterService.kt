package com.kids.data.remote.source

import com.kids.data.remote.response.DayCareCenterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface DayCareCenterService {

    @GET("api/notice/basicInfo.do")
    suspend fun getDayCareCenters(
        @Query("key") key: String,
        @Query("currentPage") currentPage: Int,
        @Query("pageCnt") pageCount: Int,
        @Query("sidoCode") sidoCode: String,
        @Query("sggCode") sggCode: String
    ): Response<DayCareCenterListResponse>
}
