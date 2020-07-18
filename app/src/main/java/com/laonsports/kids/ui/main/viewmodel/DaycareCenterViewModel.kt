package com.laonsports.kids.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laonsports.kids.common.base.BaseViewModel
import com.laonsports.kids.domain.CeterListRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DaycareCenterViewModel @ViewModelInject constructor(
    private val centerListRepository: CeterListRepository
) : BaseViewModel() {

    fun getCenterListStream() = viewModelScope.launch {
        val resCenterListDeferred = async{centerListRepository.getList()}

    }
}