package com.kids.data.remote.source

import androidx.paging.PagingSource
import com.kids.constants.DayCareConstants
import com.kids.data.remote.response.DayCareCenterListResponse
import com.kids.data.remote.response.mapToModel
import com.kids.ui.main.model.DaycareCenterModel
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class CenterListDataSourceImpl @Inject constructor(
    private val dayCareCenterService: DayCareCenterService
) : PagingSource<Int, DaycareCenterModel>(), CenterListDataSource {

    private val initialPageIndex: Int = 1
    var sidoCode: String = ""
    var sggCode: String = ""

    fun setArea(sidoCode: String, sggCode: String) {
        this.sidoCode = sidoCode
        this.sggCode = sggCode
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DaycareCenterModel> {
        val position = params.key ?: initialPageIndex
        return try {
            val localData = getDayCareCenters(
                key = DayCareConstants.API_KEY,
                currentPage = position,
                pageCount = 30,
                sidoCode = sidoCode,
                sggCode = sggCode
            ).body()?.mapToModel()

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

    override suspend fun getDayCareCenters(
        key: String,
        currentPage: Int,
        pageCount: Int,
        sidoCode: String,
        sggCode: String
    ): Response<DayCareCenterListResponse> =
        dayCareCenterService.getDayCareCenters(
            key = DayCareConstants.API_KEY,
            currentPage = currentPage,
            pageCount = 30,
            sidoCode = sidoCode,
            sggCode = sggCode
        )

}