package com.kids.db

import android.content.Context
import com.kids.ui.bookmark.model.BookmarkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookmarkDataSource @Inject constructor(){

    private val ioDispatcher = Dispatchers.IO

    suspend fun selectBookmarkList(
        context: Context
    ): DataBaseResult<List<BookmarkModel>> =
        withContext(ioDispatcher) {
            return@withContext try {
                DataBaseResult.Success(
                    BookmarkDatabase.getInstance(context).bookmarkDao().selectAll())
            } catch (e: Exception) {
                DataBaseResult.Failure(e)
            }
        }

    suspend fun insertBookMark(context: Context, model: BookmarkModel) =
        withContext(ioDispatcher) {
            return@withContext BookmarkDatabase.getInstance(context).bookmarkDao().insert(model)
        }

    suspend fun deleteBookMark(context: Context, model: BookmarkModel) =
        withContext(ioDispatcher) {
            return@withContext BookmarkDatabase.getInstance(context).bookmarkDao().delete(model)
        }
}