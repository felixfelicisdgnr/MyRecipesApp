package com.doganur.myrecipesapp.ui.categorymeals

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentCategoryMealsBinding
import com.doganur.myrecipesapp.ui.home.HomeFragmentDirections

class CategoryMealsFragment : Fragment() {

    private val binding by viewBinding(FragmentCategoryMealsBinding::bind)

    private val categoryMealsViewModel: CategoryMealsViewModel by viewModels()

    private val categoryMealsAdapter by lazy { CategoryMealsAdapter(::onCategoryMealsClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()

    }

    private fun initObservers() {

        with(binding) {
            categoryMealsViewModel.mealsByCategoryDetailList.observe(viewLifecycleOwner) { it ->
                if (it != null) {
                    categoryMealsAdapter.submitList(it)
                    rvCategoryMealsFragment.adapter = categoryMealsAdapter
                } else {
                    Toast.makeText(requireContext(), "Empty List!", Toast.LENGTH_LONG).show()
                }

                tvCategoryCount.text = it?.size.toString()

            }
        }
    }

    private fun onCategoryMealsClick(mealsByCategoryId: String) {
        val action = HomeFragmentDirections.categoryToCategories(mealsByCategoryId)
        findNavController().navigate(action)
    }
}