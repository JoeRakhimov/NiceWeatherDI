package com.joerakhimov.niceweatherdi.di

import com.joerakhimov.niceweatherdi.data.ImageLoader
import com.joerakhimov.niceweatherdi.data.PicassoImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    @ActivityScoped
    fun provideImageLoader(): ImageLoader = PicassoImageLoader()

}