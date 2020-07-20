package com.kids.common.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kids.R
import com.kids.common.base.component.ListAdapterComponent
import com.kids.common.base.component.RecyclerAdapterComponent

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceItems")
fun <T> setReplaceItems(recyclerView: RecyclerView, item: List<T>?) {
    item?.let{
        if (recyclerView.adapter is RecyclerAdapterComponent<*>) {
            (recyclerView.adapter as RecyclerAdapterComponent<T>).replaceItems(it)
        }
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun <T> setSubmitList(recyclerView: RecyclerView, item: List<T>?) {
    item?.let{
        if (recyclerView.adapter is ListAdapterComponent<*>) {
            (recyclerView.adapter as ListAdapterComponent<T>).replaceItems(it)
        }
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