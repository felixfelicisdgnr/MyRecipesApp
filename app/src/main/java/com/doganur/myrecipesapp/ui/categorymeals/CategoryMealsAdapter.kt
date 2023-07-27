package com.doganur.myrecipesapp.ui.categorymeals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.MealItemBinding
import com.doganur.myrecipesapp.db.model.MealsByCategory

class CategoryMealsAdapter(
    private val onCategoryMealsClick: (String) -> Unit
) : ListAdapter<MealsByCategory, CategoryMealsAdapter.CategoryMealsViewHolder>(CategoryDiff()) {

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
        fun bind(mealsByCategoryProduct: MealsByCategory) {
            with(binding) {

                Glide.with(imgMeal).load(mealsByCategoryProduct.strMealThumb).into(imgMeal)

                tvMealName.text = mealsByCategoryProduct.strMeal

                root.setOnClickListener {
                    mealsByCategoryProduct.idMeal?.let { onCategoryMealsClick }
                }
            }
        }
    }
}

class CategoryDiff : DiffUtil.ItemCallback<MealsByCategory>() {
    override fun areItemsTheSame(oldItem: MealsByCategory, newItem: MealsByCategory): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: MealsByCategory, newItem: MealsByCategory): Boolean {
        return oldItem == newItem
    }
}