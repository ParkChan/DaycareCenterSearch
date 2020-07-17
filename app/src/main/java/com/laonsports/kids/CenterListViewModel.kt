package com.laonsports.kids

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laonsports.kids.repository.CeterListRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CenterListViewModel @ViewModelInject constructor(
    private val centerListRepository: CeterListRepository
) : ViewModel() {

    fun getCenterList() = viewModelScope.launch {
        val resCenterListDeferred = async{centerListRepository.getList()}
        val networkResult = resCenterListDeferred.await()

    }
}