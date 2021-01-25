package com.kids.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.kids.ui.main.model.DaycareCenterModel
import javax.inject.Inject

class DaycareCenterRepository @Inject constructor(
    private val centerListDataSource: CenterListDataSource
) {
    fun getCenterList(
        sidoCode: String,
        sggCode: String
    ): Pager<Int, DaycareCenterModel> {
        return Pager(
            config = PagingConfig(pageSize = 60),
            pagingSourceFactory = { centerListDataSource.apply { setArea(sidoCode, sggCode) } })
    }

}