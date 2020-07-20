package com.kids.ui.bookmark.adapter

import android.util.ArrayMap
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.kids.common.base.adapter.BaseListAdapter
import com.kids.common.base.component.ListAdapterComponent
import com.kids.common.data.ViewHolderIdData
import com.kids.ui.bookmark.model.BookmarkModel

class BookmarkAdapter(
    viewHolderIdData: ViewHolderIdData,
    viewModels: ArrayMap<Int, ViewModel>? = null,
    diffCallback: DiffUtil.ItemCallback<BookmarkModel>
) : BaseListAdapter<BookmarkModel>(viewHolderIdData, viewModels, diffCallback), ListAdapterComponent<BookmarkModel>{

    override fun replaceItems(items: List<BookmarkModel>?) {
        items?.let{
            submitList(it)
        }
    }

}