package com.kids.ui.main.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kids.R
import com.kids.ui.bookmark.repository.BookmarkRepository
import com.kids.ui.main.domain.DaycareCenterRepository
import com.kids.ui.main.model.DaycareCenterModel
import com.kids.ui.main.model.mapToBookmarkModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DaycareCenterViewModel @ViewModelInject constructor(
    private val centerListRepository: DaycareCenterRepository,
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {

    private val _onClickedCall = MutableLiveData<DaycareCenterModel>()
    val onClickedCall: LiveData<DaycareCenterModel> get() = _onClickedCall

    fun getCenterListStream(
        sidoCode: String,
        sggCode: String
    ): Flow<PagingData<DaycareCenterModel>> =
        centerListRepository.getCenterList(sidoCode, sggCode).flow.cachedIn(viewModelScope)

    fun onClickCall(item: DaycareCenterModel?) {
        item?.let {
            _onClickedCall.value = item
        }
    }

    fun onClickBookmark(context: Context, item: DaycareCenterModel?) {
        if (item == null) return

        viewModelScope.launch {
            bookmarkRepository.insertBookMark(
                context,
                item.mapToBookmarkModel()
            )
            Toast.makeText(
                context,
                context.getString(
                    R.string.toast_message_add_bookmark,
                    item.kindername
                ), Toast.LENGTH_SHORT
            ).show()
        }
    }
}