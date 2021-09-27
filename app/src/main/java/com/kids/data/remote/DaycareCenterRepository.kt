package com.kids.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.kids.data.remote.source.CenterListDataSourceImpl
import com.kids.ui.main.model.DaycareCenterModel
import javax.inject.Inject

class DaycareCenterRepository @Inject constructor(
    private val centerListDataSourceImpl: CenterListDataSourceImpl
) {
    fun getCenterList(
        sidoCode: String,
        sggCode: String
    ): Pager<Int, DaycareCenterModel> {
        return Pager(
            config = PagingConfig(pageSize = 60),
            pagingSourceFactory = {
                centerListDataSourceImpl.apply {
                    setArea(sidoCode, sggCode)
                }
            }
        )
    }

}