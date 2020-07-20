package com.kids.common.base.component

interface ListAdapterComponent<T>{
    fun replaceItems(items: List<T>?)
}