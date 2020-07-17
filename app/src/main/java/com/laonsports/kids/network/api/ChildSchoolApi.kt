package com.laonsports.kids.network.api

import com.laonsports.kids.entity.ChildSchoolResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ChildSchoolApi {

    @GET("api/notice/basicInfo.do")
    suspend fun getSchoolList(
        @Query("key") key: String,
        @Query("currentPage") currentPage: Int,
        @Query("pageCount") pageCount: Int,
        @Query("sidoCode") sidoCode: Int,
        @Query("sggCode") sggCode: Int
    ): Response<ChildSchoolResponse>
}
