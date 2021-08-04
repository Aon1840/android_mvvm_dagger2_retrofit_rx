package com.bearman.android_mvvm_dagger2_retrofit_rx.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.android_mvvm_dagger2_retrofit_rx.model.Country

class ListViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        val mockData = listOf(Country("Country1"),
            Country("Country2"),
            Country("Country3"),
            Country("Country4"),
            Country("Country5"),
            Country("Country6"),
            Country("Country7"),
            Country("Country8")
        )

        countryLoadError.value = false
        loading.value = false
        countries.value = mockData
    }
}