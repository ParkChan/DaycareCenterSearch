package com.kids.db

import androidx.room.Dao
import androidx.room.Query
import com.kids.ui.bookmark.model.BookmarkModel

@Dao
interface BookmarkDao : BaseDao<BookmarkModel> {

    @Query("SELECT * FROM bookmarkTable")
    suspend fun selectAll(): List<BookmarkModel>

}

