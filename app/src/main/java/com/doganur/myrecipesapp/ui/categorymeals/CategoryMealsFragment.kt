package com.doganur.myrecipesapp.ui.categorymeals

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentCategoryMealsBinding
import com.doganur.myrecipesapp.ui.home.HomeFragmentDirections

class CategoryMealsFragment : Fragment(R.layout.fragment_category_meals) {

    private val binding by viewBinding(FragmentCategoryMealsBinding::bind)

    private val categoryMealsViewModel: CategoryMealsViewModel by viewModels()

    private val categoryMealsAdapter by lazy { CategoryMealsAdapter(::onCategoryMealsClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()

    }

    private fun initObservers() {

        with(binding) {
            categoryMealsViewModel.mealsByCategoryDetailList.observe(viewLifecycleOwner) {

                Log.d("ROSE ROSE", it?.size.toString())
                println("rose rose rose ")

                if (!it.isNullOrEmpty()) {
                    rvCategoryMealsFragment.adapter = categoryMealsAdapter
                    categoryMealsAdapter.submitList(it)
                    println(it.size.toString())
                    Log.d("fuckkkkk", it.size.toString())
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