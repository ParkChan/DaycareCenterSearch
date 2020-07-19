package com.kids.ui.main.model

/**
 * @param kindername : 유치원 이름
 * @param addr : 주소
 * @param opertime : 운영시간
 */
data class DaycareCenterModel(
    val key: String = "",
    val kindername: String = "",
    val addr: String = "",
    val telno: String = "",
    val opertime: String = ""
)