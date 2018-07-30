package com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel

class RentViewModelFactory(
        val storageModel : StorageModel,
        val rentModel : RentModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RentViewModel(storageModel,rentModel) as T
    }
}