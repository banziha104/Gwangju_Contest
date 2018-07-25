package com.nicname.iyeongjun.gwangju_contest.di.mod.global

import com.google.gson.Gson
import com.nicname.iyeongjun.gwangju_contest.api.data.*
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.Item
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class LocalModule{
    @Singleton
    @Provides
    fun provideRentModel(gson : Gson) = gson.fromJson(bikeRentLocationData, RentModel::class.java)


    @Singleton
    @Named("s")
    @Provides
    fun provideStorageModelSouth(gson : Gson) = gson.fromJson(sBikeStorageData, StorageModel::class.java)

    @Singleton
    @Named("w")
    @Provides
    fun provideStorageModelWest(gson : Gson) = gson.fromJson(wBikeStorageData, StorageModel::class.java)

    @Singleton
    @Named("e")
    @Provides
    fun provideStorageModelEast(gson : Gson) = gson.fromJson(eBikeStorageData, StorageModel::class.java)

    @Singleton
    @Named("n")
    @Provides
    fun provideNstorageModelNorth(gson : Gson) = gson.fromJson(nBikeStorageData, StorageModel::class.java)


    @Singleton
    @Named("merged")
    @Provides
    fun provideStorageModelMerged(@Named("w") w : StorageModel,
                                  @Named("s") s : StorageModel,
                                  @Named("e") e : StorageModel,
                                  @Named("n") n : StorageModel
                                  ) : StorageModel{
        val temp = w.items as ArrayList
        temp.addAll(s.items as ArrayList)
        temp.addAll(e.items as ArrayList)
        temp.addAll(n.items as ArrayList)
        return StorageModel(temp as List<Item>)
    }
    @Singleton
    @Provides
    fun provideGson() = Gson()
}