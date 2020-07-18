package com.kids.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.kids.ui.main.model.DaycareCenterModel

internal class DaycareCenterDiffer : DiffUtil.ItemCallback<DaycareCenterModel>() {
    override fun areItemsTheSame(
        oldItem: DaycareCenterModel,
        newItem: DaycareCenterModel
    ): Boolean = oldItem.key == newItem.key

    override fun areContentsTheSame(
        oldItem: DaycareCenterModel,
        newItem: DaycareCenterModel
    ): Boolean = oldItem == newItem
}