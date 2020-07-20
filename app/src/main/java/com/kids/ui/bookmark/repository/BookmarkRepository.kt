package com.kids.ui.bookmark.repository

import android.content.Context
import com.kids.ui.bookmark.db.BookmarkDataSource
import com.kids.ui.bookmark.db.DataBaseResult
import com.kids.ui.bookmark.model.BookmarkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookmarkRepository @Inject constructor(private val bookmarkDataSource: BookmarkDataSource) {

    private val ioDispatcher = Dispatchers.IO

    suspend fun selectBookmarkList(
        context: Context
    ): DataBaseResult<List<BookmarkModel>> =
        withContext(ioDispatcher) {
            return@withContext bookmarkDataSource.selectBookmarkList(context)
        }

    suspend fun insertBookMark(context: Context, model: BookmarkModel) =
        withContext(ioDispatcher) {
            return@withContext bookmarkDataSource.insertBookMark(context, model)
        }

    suspend fun deleteBookMark(context: Context, model: BookmarkModel) =
        withContext(ioDispatcher) {
            return@withContext bookmarkDataSource.deleteBookMark(context, model)
        }
}