package com.laonsports.kids.common.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laonsports.kids.common.BindListAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T?) {
    if (recyclerView.adapter is BindListAdapter<*>) {
        (recyclerView.adapter as BindListAdapter<T>).addAllData(data)
    }
}
