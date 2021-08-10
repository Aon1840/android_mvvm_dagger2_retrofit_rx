package com.bearman.android_mvvm_dagger2_retrofit_rx.di

import com.bearman.android_mvvm_dagger2_retrofit_rx.model.CountriesService
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun provideCountriesService(): CountriesService {
        return CountriesService()
    }
}