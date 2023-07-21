package com.doganur.myrecipesapp.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.databinding.CategoryItemBinding
import com.doganur.myrecipesapp.db.model.Category

class CategoriesAdapter : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(CategoryDiff()) {

    var onClick : (Category) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class CategoryViewHolder(private val binding: CategoryItemBinding, private val onClick : (Category) -> Unit ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productCategory : Category){
            with(binding) {
                tvNameCategory.text = productCategory.strCategory

                Glide.with(imgCategory).load(productCategory.strCategoryThumb).into(imgCategory)

                root.setOnClickListener { onClick(productCategory) }
            }
        }
    }
}

class CategoryDiff : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.idCategory == newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}