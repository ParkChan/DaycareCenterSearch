package com.kids.ui.bookmark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarkTable")
data class BookmarkModel(
    @PrimaryKey
    val key: String = "",
    val kindername: String = "",
    val addr: String = "",
    val telno: String = "",
    val opertime: String = ""
)
