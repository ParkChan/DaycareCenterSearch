package com.laonsports.kids.ui.main.model

data class DaycareCenterListModel(

    val pageCnt: Int = 0,
    val currentPage: Int = 0,
    val sidoList: String = "",
    val sggList: String = "",
    val daycareCenterList: List<DaycareCenterModel> = emptyList()

)

