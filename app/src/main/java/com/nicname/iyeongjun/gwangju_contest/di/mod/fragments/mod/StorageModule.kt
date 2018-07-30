package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage.StorageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class StorageModule{
    @Provides
    fun provideStorageViewModelFactory() = StorageViewModelFactory()
}