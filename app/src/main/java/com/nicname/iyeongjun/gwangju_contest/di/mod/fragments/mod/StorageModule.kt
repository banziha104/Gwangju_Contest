package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage.StorageViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class StorageModule{
    @Provides
    fun provideStorageViewModelFactory(@Named("merged") storageModel : StorageModel) = StorageViewModelFactory(storageModel)
}