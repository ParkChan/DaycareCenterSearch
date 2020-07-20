package com.kids.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookmarkEventViewModel: ViewModel() {

    private val _bookmarkListChanged = MutableLiveData<Boolean>()
    var bookmarkListChanged: LiveData<Boolean> = _bookmarkListChanged

    fun notifyChanged(){
        _bookmarkListChanged.value = true
    }
}