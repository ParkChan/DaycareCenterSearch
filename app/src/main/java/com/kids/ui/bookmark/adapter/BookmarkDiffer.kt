package com.kids.ui.bookmark.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kids.ui.bookmark.model.BookmarkModel

internal class BookmarkDiffer : DiffUtil.ItemCallback<BookmarkModel>() {
    override fun areItemsTheSame(
        oldItem: BookmarkModel,
        newItem: BookmarkModel
    ): Boolean = oldItem.key == newItem.key

    override fun areContentsTheSame(
        oldItem: BookmarkModel,
        newItem: BookmarkModel
    ): Boolean = oldItem == newItem
}