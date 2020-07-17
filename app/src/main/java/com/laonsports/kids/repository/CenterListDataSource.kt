package com.laonsports.kids.repository

import com.laonsports.kids.constants.DayCareConstants
import com.laonsports.kids.entity.ChildSchoolResponse
import com.laonsports.kids.network.api.ChildSchoolApi
import retrofit2.Response
import javax.inject.Inject

class CenterListDataSource @Inject constructor(
    private val childSchoolApi: ChildSchoolApi
) {

    suspend fun getSchoolList(
        currentPage: Int,
        pageCount: Int,
        sidoCode: Int,
        sggCode: Int
    ): Response<ChildSchoolResponse> =
        childSchoolApi.getSchoolList(
            DayCareConstants.API_KEY,
            currentPage,
            pageCount,
            sidoCode,
            sggCode
        )
}