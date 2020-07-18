package com.kids.common.base

import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kids.common.data.ViewHolderIdData

open class BaseViewHolder(
    parent: ViewGroup,
    private val viewHolderIdData: ViewHolderIdData,
    private val viewModels: ArrayMap<Int, BaseViewModel>? = null
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(viewHolderIdData.layoutId, parent, false)
) {
    private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    open fun bindViewHolder(item: Any?, position: Int) {
        if (item == null) return
        binding.setVariable(viewHolderIdData.modelId, item)
        binding.setVariable(viewHolderIdData.positionId, position)

        if (viewModels == null) return
        for (key in viewModels.keys) {
            binding.setVariable(key, viewModels[key])
        }
    }
}