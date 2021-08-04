package com.bearman.android_mvvm_dagger2_retrofit_rx.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bearman.android_mvvm_dagger2_retrofit_rx.R
import com.bearman.android_mvvm_dagger2_retrofit_rx.model.Country

class CountryListAdapter(
    var countries: ArrayList<Country>
) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val countryName: TextView = view.findViewById(R.id.tvName)

        fun bind(country: Country) {
            countryName.text = country.countryName
        }
    }
}