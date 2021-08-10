package com.bearman.android_mvvm_dagger2_retrofit_rx.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bearman.android_mvvm_dagger2_retrofit_rx.R
import com.bearman.android_mvvm_dagger2_retrofit_rx.model.Country
import com.bearman.android_mvvm_dagger2_retrofit_rx.utils.getProgressDrawable
import com.bearman.android_mvvm_dagger2_retrofit_rx.utils.loadImage
import kotlinx.android.synthetic.main.item_country.view.ivCountry
import kotlinx.android.synthetic.main.item_country.view.tvName
import kotlinx.android.synthetic.main.item_country.view.tvCapital

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

        fun bind(country: Country) {
            itemView.rootView.apply {
                ivCountry.loadImage(country.flag, getProgressDrawable(context))
                tvName.text = country.countryName
                tvCapital.text = country.capital
            }
        }
    }
}