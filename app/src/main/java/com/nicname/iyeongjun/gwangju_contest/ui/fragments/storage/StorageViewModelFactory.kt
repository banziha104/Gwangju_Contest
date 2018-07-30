package com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel

class StorageViewModelFactory(val storageModel : StorageModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StorageViewModel(storageModel) as T
    }
}