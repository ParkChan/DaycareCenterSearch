package com.kids.common.base

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kids.common.data.ViewHolderIdData

class BaseListAdapter<ITEM : Any>(
    private val viewHolderIdData: ViewHolderIdData,
    private val viewModels: ArrayMap<Int, BaseViewModel>? = null,
    diffCallback: DiffUtil.ItemCallback<ITEM>
) : PagingDataAdapter<ITEM, BaseViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            parent,
            viewHolderIdData,
            viewModels
        )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position), position)
    }

}