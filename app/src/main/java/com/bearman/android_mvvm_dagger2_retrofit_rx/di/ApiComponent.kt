package com.bearman.android_mvvm_dagger2_retrofit_rx.di

import com.bearman.android_mvvm_dagger2_retrofit_rx.model.CountriesService
import com.bearman.android_mvvm_dagger2_retrofit_rx.viewModel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class, ServiceModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}