package com.laonsports.kids.network

import com.laonsports.kids.domain.entity.DaycareCenterListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ChildSchoolApi {

    @GET("api/notice/basicInfo.do")
    suspend fun getDaycareCenterList(
        @Query("key") key: String,
        @Query("currentPage") currentPage: Int,
        @Query("pageCount") pageCount: Int,
        @Query("sidoCode") sidoCode: Int,
        @Query("sggCode") sggCode: Int
    ): Deferred<Response<DaycareCenterListResponse>>
}
