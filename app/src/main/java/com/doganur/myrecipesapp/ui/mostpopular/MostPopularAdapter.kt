package com.doganur.myrecipesapp.ui.mostpopular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.PopularItemBinding
import com.doganur.myrecipesapp.db.model.MealsByCategory

class MostPopularAdapter(
    private val onPopularClick: (String) -> Unit
) : ListAdapter<MealsByCategory, MostPopularAdapter.MostPopularViewHolder>(
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

        fun bind(mostPopularProduct: MealsByCategory) {

            Glide.with(binding.imgPopularMealItems).load(mostPopularProduct.strMealThumb)
                .into(binding.imgPopularMealItems)

            binding.root.setOnClickListener {
                mostPopularProduct.idMeal?.let( onPopularClick )
            }
        }
    }
}

object MostPopularDiffUtilCallback : DiffUtil.ItemCallback<MealsByCategory>() {
    override fun areItemsTheSame(oldItem: MealsByCategory, newItem: MealsByCategory) =
        oldItem.idMeal == newItem.idMeal

    override fun areContentsTheSame(oldItem: MealsByCategory, newItem: MealsByCategory) =
        oldItem == newItem
}