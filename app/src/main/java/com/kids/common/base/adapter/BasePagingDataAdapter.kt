package com.kids.common.base.adapter

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kids.common.data.ViewHolderIdData

open class BasePagingDataAdapter<ITEM : Any>(
    private val viewHolderIdData: ViewHolderIdData,
    private val viewModels: ArrayMap<Int, ViewModel>? = null,
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