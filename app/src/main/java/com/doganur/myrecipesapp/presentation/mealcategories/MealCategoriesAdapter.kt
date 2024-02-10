package com.doganur.myrecipesapp.presentation.mealcategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.MealItemBinding
import com.doganur.myrecipesapp.data.model.MealsByCategoryForPopular

class CategoryMealsAdapter(
    private val onCategoryMealsClick: (String) -> Unit
) : ListAdapter<MealsByCategoryForPopular, CategoryMealsAdapter.CategoryMealsViewHolder>(CategoryDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewHolder {
        val binding =
            MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryMealsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryMealsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CategoryMealsViewHolder(
        private val binding: MealItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mealsByCategoryForPopularProduct: MealsByCategoryForPopular) {

            with(binding) {

                Glide.with(imgMeal).load(mealsByCategoryForPopularProduct.strMealThumb).into(imgMeal)

                tvMealName.text = mealsByCategoryForPopularProduct.strMeal

                root.setOnClickListener {
                    mealsByCategoryForPopularProduct.strMeal?.let {
                        onCategoryMealsClick(
                            mealsByCategoryForPopularProduct.strMeal
                        )
                    }
                }
            }
        }
    }
}

class CategoryDiff : DiffUtil.ItemCallback<MealsByCategoryForPopular>() {
    override fun areItemsTheSame(oldItem: MealsByCategoryForPopular, newItem: MealsByCategoryForPopular): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: MealsByCategoryForPopular, newItem: MealsByCategoryForPopular): Boolean {
        return oldItem == newItem
    }
}