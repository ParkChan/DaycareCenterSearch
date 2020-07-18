package com.laonsports.kids.domain

import androidx.paging.PagingSource
import com.laonsports.kids.constants.DayCareConstants
import com.laonsports.kids.domain.entity.mapToModel
import com.laonsports.kids.network.ChildSchoolApi
import com.laonsports.kids.ui.main.model.DaycareCenterModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CenterListDataSource @Inject constructor(
    private val childSchoolApi: ChildSchoolApi,
) : PagingSource<Int, DaycareCenterModel>() {

//    suspend fun getSchoolList(
//        currentPage: Int,
//        pageCount: Int,
//        sidoCode: Int,
//        sggCode: Int
//    ): DaycareCenterListResponse =
//        childSchoolApi.getDaycareCenterList(
//            DayCareConstants.API_KEY,
//            currentPage,
//            pageCount,
//            sidoCode,
//            sggCode
//        )

    private val initialPageIndex: Int = 1
    var sidoCode: Int = 0
    var sggCode: Int = 0

    fun areaSetting(sidoCode: Int, sggCode: Int){
        this.sidoCode = sidoCode
        this.sggCode = sggCode
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DaycareCenterModel> {
        val position = params.key ?: initialPageIndex
        return try {
            val networkResult = childSchoolApi.getDaycareCenterList(
                DayCareConstants.API_KEY,
                position, 60, sidoCode, sggCode
            ).await()

            val localData = networkResult.body()?.mapToModel()

            LoadResult.Page(
                data = localData?.daycareCenterList!!,
                prevKey = if (position == initialPageIndex) null else position - 1,
                nextKey = if (localData.daycareCenterList.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}