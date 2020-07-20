package com.kids.common.base.component

interface RecyclerAdapterComponent<T>{
    fun replaceItems(items: List<T>?)
    fun addAllItems(items: List<T>?)
}