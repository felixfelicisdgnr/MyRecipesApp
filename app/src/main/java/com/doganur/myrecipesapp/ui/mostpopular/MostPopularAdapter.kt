package com.doganur.myrecipesapp.ui.mostpopular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.PopularItemBinding
import com.doganur.myrecipesapp.data.model.MealsByCategoryForPopular

class MostPopularAdapter(
    private val onPopularClick: (String) -> Unit
) : ListAdapter<MealsByCategoryForPopular, MostPopularAdapter.MostPopularViewHolder>(
    MostPopularDiffUtilCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularViewHolder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MostPopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MostPopularViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class MostPopularViewHolder(
        private val binding: PopularItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mostPopularProduct: MealsByCategoryForPopular) {

            Glide.with(binding.imgPopularMealItems).load(mostPopularProduct.strMealThumb)
                .into(binding.imgPopularMealItems)

            binding.root.setOnClickListener {
                mostPopularProduct.idMeal?.let( onPopularClick )
            }
        }
    }
}

object MostPopularDiffUtilCallback : DiffUtil.ItemCallback<MealsByCategoryForPopular>() {
    override fun areItemsTheSame(oldItem: MealsByCategoryForPopular, newItem: MealsByCategoryForPopular) =
        oldItem.idMeal == newItem.idMeal

    override fun areContentsTheSame(oldItem: MealsByCategoryForPopular, newItem: MealsByCategoryForPopular) =
        oldItem == newItem
}