package com.kids.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kids.common.base.BaseViewModel
import com.kids.ui.main.domain.DaycareCenterRepository
import com.kids.ui.main.model.DaycareCenterModel
import kotlinx.coroutines.flow.Flow

class DaycareCenterViewModel @ViewModelInject constructor(
    private val centerListRepository: DaycareCenterRepository
) : BaseViewModel() {

    private val _selectedItem = MutableLiveData<DaycareCenterModel>()
    val selectedItem: LiveData<DaycareCenterModel> get() = _selectedItem

    fun getCenterListStream(
        sidoCode: String,
        sggCode: String
    ): Flow<PagingData<DaycareCenterModel>> =
        centerListRepository.getCenterList(sidoCode, sggCode).flow.cachedIn(viewModelScope)

    override fun onClick(item: Any?) {
        if(item is DaycareCenterModel){
            _selectedItem.value = item
        }
    }
}