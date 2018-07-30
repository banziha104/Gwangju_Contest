package com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class StorageViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StorageViewModel() as T
    }
}