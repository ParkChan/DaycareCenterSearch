package com.kids.ui.bookmark.viewmodel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kids.data.local.DataBaseResult
import com.kids.ui.bookmark.model.BookmarkModel
import com.kids.ui.bookmark.repository.BookmarkRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class BookmarkViewModel @ViewModelInject constructor(
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {

    private val _bookmarkListData = MutableLiveData<List<BookmarkModel>>()
    val bookmarkListData: LiveData<List<BookmarkModel>> get() = _bookmarkListData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _onClickedCall = MutableLiveData<BookmarkModel>()
    val onClickedCall: LiveData<BookmarkModel> get() = _onClickedCall

    fun selectAll(context: Context) = viewModelScope.launch {

        val bookmarkResult =
            async { bookmarkRepository.selectBookmarkList(context) }

        when (val dbResult = bookmarkResult.await()) {
            is DataBaseResult.Success -> {
                dbResult.data.run {
                    _bookmarkListData.postValue(this)
                }
            }
            is DataBaseResult.Failure -> {
                _errorMessage.postValue(dbResult.exception.message ?: "")
            }
        }
    }

    private fun removeBookmark(context: Context, model: BookmarkModel) = viewModelScope.launch {
        bookmarkRepository.deleteBookMark(context, model)
        selectAll(context)
    }

    fun onClickCall(item: BookmarkModel?) {
        item?.let {
            _onClickedCall.value = it
        }
    }

    fun onClickRemoveBookmark(context: Context, item: BookmarkModel?) {
        item?.let {
            removeBookmark(context, it)
        }
    }

}