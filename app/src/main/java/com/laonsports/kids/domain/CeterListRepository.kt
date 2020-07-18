package com.laonsports.kids.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.laonsports.kids.domain.CenterListDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CeterListRepository @Inject constructor(private val centerListDataSource: CenterListDataSource) {

    private val ioDispatcher = Dispatchers.IO

    suspend fun getList(){
        withContext(ioDispatcher) {
            return@withContext try {
                centerListDataSource.getSchoolList(1, 30, 11, 11710)
            } catch (e: Exception) {

            }
        }
    }

    fun getProductList(sidoCode: Int, sggCode: Int) = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { centerListDataSource.apply { sggCode = sidoCode  } })
}