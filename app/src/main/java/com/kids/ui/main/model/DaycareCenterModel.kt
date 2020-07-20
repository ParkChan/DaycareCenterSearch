package com.kids.ui.main.model

import com.kids.ui.bookmark.model.BookmarkModel

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
fun DaycareCenterModel?.mapToBookmarkModel() = this?.let {
    BookmarkModel(
        key = key,
        kindername = kindername,
        addr = addr,
        telno = telno,
        opertime = opertime
    )
} ?: BookmarkModel()

