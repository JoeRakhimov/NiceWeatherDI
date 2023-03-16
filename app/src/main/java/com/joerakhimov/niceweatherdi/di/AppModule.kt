package com.joerakhimov.niceweatherdi.di

import com.joerakhimov.niceweatherdi.data.Api
import com.joerakhimov.niceweatherdi.data.BASE_URL
import com.joerakhimov.niceweatherdi.data.RepositoryImpl
import com.joerakhimov.niceweatherdi.data.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.text.Typography.dagger

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

//    @Provides
//    fun provideRepository(api: Api): Repository = RepositoryImpl(api)

    @InstallIn(SingletonComponent::class)
    @Module
    interface Bindings {
        @Binds
        fun bindRepository(repository: RepositoryImpl): Repository
    }

}