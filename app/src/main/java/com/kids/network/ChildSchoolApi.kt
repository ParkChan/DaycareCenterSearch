package com.kids.network

import com.kids.ui.main.domain.entity.DaycareCenterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ChildSchoolApi {

    @GET("api/notice/basicInfo.do")
    suspend fun getDaycareCenterListAsync(
        @Query("key") key: String,
        @Query("currentPage") currentPage: Int,
        @Query("pageCnt") pageCount: Int,
        @Query("sidoCode") sidoCode: String,
        @Query("sggCode") sggCode: String
    ): Response<DaycareCenterListResponse>
}
