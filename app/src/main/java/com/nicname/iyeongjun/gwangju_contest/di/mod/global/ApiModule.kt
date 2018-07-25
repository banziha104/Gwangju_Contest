package com.nicname.iyeongjun.gwangju_contest.di.mod.global

import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.const.T_BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    fun provideWeatherModel(rxAdapter: CallAdapter.Factory,
                            gsonConverter: Converter.Factory,
                            client: OkHttpClient)
    = Retrofit.Builder()
            .baseUrl(T_BASE_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(gsonConverter)
            .build()
            .create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory // RxConvererter
            = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory // GsonFactory
            = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient
            = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
}