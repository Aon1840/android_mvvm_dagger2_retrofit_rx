package com.bearman.android_mvvm_dagger2_retrofit_rx.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bearman.android_mvvm_dagger2_retrofit_rx.R
import com.bearman.android_mvvm_dagger2_retrofit_rx.adapter.CountryListAdapter
import com.bearman.android_mvvm_dagger2_retrofit_rx.viewModel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel
    private val countryListAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        rvCountries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryListAdapter
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                rvCountries.visibility = View.VISIBLE
                countryListAdapter.updateCountries(it)
            }
        })
        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let {
                tvErrorMessage.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                progressBar.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

                if (it) {
                    tvErrorMessage.visibility = View.GONE
                    rvCountries.visibility = View.GONE
                }
            }
        })
    }
}