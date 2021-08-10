package com.bearman.android_mvvm_dagger2_retrofit_rx.di

import com.bearman.android_mvvm_dagger2_retrofit_rx.model.CountriesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)
}