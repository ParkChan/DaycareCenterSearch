package com.kids.common.base.adapter

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.kids.common.data.ViewHolderIdData

open class BaseRecyclerAdapter<ITEM : Any>(
    private val viewHolderIdData: ViewHolderIdData,
    private val viewModels: ArrayMap<Int, ViewModel>? = null
) : RecyclerView.Adapter<BaseViewHolder>() {

    protected val itemList = mutableListOf<ITEM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            parent,
            viewHolderIdData,
            viewModels
        )

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindViewHolder(itemList[position], position)
    }
}