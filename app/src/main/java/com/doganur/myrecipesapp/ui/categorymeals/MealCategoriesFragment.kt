package com.doganur.myrecipesapp.ui.categorymeals

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentCategoryMealsBinding

class MealCategoriesFragment : Fragment(R.layout.fragment_category_meals) {

    private val binding by viewBinding(FragmentCategoryMealsBinding::bind)

    private val mealCategoriesViewModel: MealCategoriesViewModel by viewModels()

    private val categoryMealsAdapter by lazy { CategoryMealsAdapter(::onCategoryMealsClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun initObservers() {

        with(binding) {
            mealCategoriesViewModel.mealsByCategoryDetailList.observe(viewLifecycleOwner) {
                if (!it.isNullOrEmpty()) {

                    rvCategoryMealsFragment.adapter = categoryMealsAdapter
                    categoryMealsAdapter.submitList(it)
                    println(it.size.toString())

                } else {
                    Toast.makeText(requireContext(), "Empty List!", Toast.LENGTH_LONG).show()
                }
                tvCategoryCount.text = it?.size.toString()
            }
        }
    }

    private fun onCategoryMealsClick(mealsByCategoryId: String) {

    }
}