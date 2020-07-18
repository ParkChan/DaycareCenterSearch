package com.kids.ui.main.domain.entity

import com.kids.ui.main.model.DaycareCenterModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DaycareCenterResponse(

    @field:Json(name = "key")    //유치원 이름
    val key: String? = null,

    @field:Json(name = "kindername")    //유치원 이름
    val kindername: String? = null,

    @field:Json(name = "addr")          //주소
    val addr: String? = null,

    @field:Json(name = "telno")         //전화번호
    val telno: String? = null,

    @field:Json(name = "opertime")      //운영시간
    val opertime: String? = null
)

fun DaycareCenterResponse?.mapToModel() = this?.let {
    DaycareCenterModel(
        key = key ?: "",
        kindername = kindername ?: "",
        addr = addr ?: "",
        telno = telno ?: "",
        opertime = opertime ?: ""
    )
} ?: DaycareCenterModel()

