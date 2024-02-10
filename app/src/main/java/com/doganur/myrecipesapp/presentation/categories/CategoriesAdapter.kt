package com.doganur.myrecipesapp.presentation.categories

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.CategoryItemBinding
import com.doganur.myrecipesapp.data.model.Category

class CategoriesAdapter(
    private val onCategoriesClick : (String) -> Unit
) : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(CategoryDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CategoryViewHolder(
        private val binding: CategoryItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productCategory: Category) {
            with(binding) {
                tvNameCategory.text = productCategory.strCategory

                Glide.with(imgCategory).load(productCategory.strCategoryThumb).into(imgCategory)

                root.setOnClickListener {
                    productCategory.strCategory?.let { onCategoriesClick(productCategory.strCategory)}
                    Log.e("TEST CATEGORIES ADAPTER", productCategory.strCategory.toString())
                }
            }
        }
    }
}

class CategoryDiff : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.strCategory == newItem.strCategory
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}