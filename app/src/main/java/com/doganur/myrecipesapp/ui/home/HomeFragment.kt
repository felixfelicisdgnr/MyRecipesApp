package com.doganur.myrecipesapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentHomeBinding
import com.doganur.myrecipesapp.ui.categories.CategoriesAdapter
import com.doganur.myrecipesapp.ui.mostpopular.MostPopularAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val homeViewModel: HomeViewModel by viewModels()

    private val mostPopularAdapter by lazy { MostPopularAdapter(::onPopularClick) }
    private val categoriesAdapter by lazy { CategoriesAdapter(::onCategoriesClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgRandomMeal.setOnClickListener {
            homeViewModel.onRandomClick()
        }

        homeViewModel.randomMeal.observe(viewLifecycleOwner) { meal ->
            Glide.with(binding.imgRandomMeal).load(meal?.strMealThumb).into(binding.imgRandomMeal)
        }

        homeViewModel.navigateToDetail.observe(viewLifecycleOwner) { id ->
            id?.let {
                onPopularClick(it)
                homeViewModel.setNavigateNull()
            }
        }

        homeViewModel.navigateToMealsByCategory.observe(viewLifecycleOwner) { id ->
            id?.let {
                onCategoriesClick(it)
                homeViewModel.onMealsByCategoriesClick()
                homeViewModel.setNavigateNull()
            }
        }

        homeViewModel.mealsByCategoryList.observe(viewLifecycleOwner) {
            if (it != null) {
                mostPopularAdapter.submitList(it)
                binding.rvMealsPopular.adapter = mostPopularAdapter
            } else {
                Toast.makeText(requireContext(), "Empty List!!!", Toast.LENGTH_LONG).show()
            }
        }

        homeViewModel.categoriesMealList.observe(viewLifecycleOwner) {
            if (it != null) {
                categoriesAdapter.submitList(it)
                binding.rvCategories.adapter = categoriesAdapter
            } else {
                Toast.makeText(requireContext(), "Empty List !!!!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun onPopularClick(mealId: String) {
        val action = HomeFragmentDirections.homeToMeal(mealId)
        findNavController().navigate(action)
    }

    private fun onCategoriesClick(categoriesId: String) {
        val action = HomeFragmentDirections.categoryToCategories(categoriesId)
        findNavController().navigate(action)
    }
}