package com.laonsports.kids.network.api

import com.laonsports.kids.constants.DayCareConstants
import com.laonsports.kids.network.retrofit.RetrofitBuilder
import com.laonsports.kids.network.retrofit.getOkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

fun searchList(
    service: ChildSchoolService,
    currentPage: Int,
    pageCount: Int,
    sidoCode: Int,
    sggCode: Int,
    onSuccess: (data: String) -> Unit,
    onError: (error: String) -> Unit
) {
    service.basicInfo(
        DayCareConstants.API_KEY,
        currentPage,
        pageCount,
        sidoCode,
        sggCode
    ).enqueue(
        object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                onError(t.message ?: "unknown error")
            }
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    response.body()?.let { onSuccess(it) }
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        })
}

interface ChildSchoolService {

    @GET("api/notice/basicInfo.do")
    fun basicInfo(
        @Query("key") key: String,
        @Query("currentPage") currentPage: Int,
        @Query("pageCount") pageCount: Int,
        @Query("sidoCode") sidoCode: Int,
        @Query("sggCode") sggCode: Int
    ): Call<String>

    companion object {
        private const val BASE_URL = "http://e-childschoolinfo.moe.go.kr/"
        fun create(): ChildSchoolService {
            return RetrofitBuilder(
                BASE_URL,
                getOkHttpClient()
            ).create(ChildSchoolService::class.java)
        }
    }
}
