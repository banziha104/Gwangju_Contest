package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent.RentViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RentModule{
    @Provides
    fun provideRentViewModelFactory(@Named("merged") storageModel : StorageModel , rentModel : RentModel) = RentViewModelFactory(storageModel,rentModel)
}