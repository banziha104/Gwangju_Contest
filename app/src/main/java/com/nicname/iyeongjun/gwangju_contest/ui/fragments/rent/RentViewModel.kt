package com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel

class RentViewModel(val storageModel : StorageModel,
                    val rentModel : RentModel) : ViewModel()