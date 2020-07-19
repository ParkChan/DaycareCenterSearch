package com.kids.common.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(){
    open fun onClick(item: Any?) = Unit
}