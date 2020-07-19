package com.kids.common.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kids.R
import com.kids.common.BindListAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T?) {
    if (recyclerView.adapter is BindListAdapter<*>) {
        (recyclerView.adapter as BindListAdapter<T>).addAllData(data)
    }
}

@BindingAdapter("operTime")
fun setOperTime(
    textView: TextView,
    str: String
) {
    val textStr = textView.context.getString(R.string.oper_time_formmat, str)
    textView.text = textStr
}

@BindingAdapter("phoneNumber")
fun setPhoneNumber(
    textView: TextView,
    str: String
) {
    val textStr = textView.context.getString(R.string.phone_nember_fommat, str)
    textView.text = textStr
}