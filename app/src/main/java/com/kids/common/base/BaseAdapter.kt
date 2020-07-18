package com.kids.common.base

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kids.common.data.ViewHolderIdData

open class BaseAdapter<ITEM : Any>(
    private val viewHolderIdData: ViewHolderIdData,
    private val viewModels: ArrayMap<Int, BaseViewModel>? = null
) : RecyclerView.Adapter<BaseViewHolder>() {

    private val itemList = mutableListOf<ITEM>()

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

    fun replaceItems(items: List<ITEM>?) {
        if (items == null) return

        itemList.run {
            clear()
            addAll(items)
        }
    }
}