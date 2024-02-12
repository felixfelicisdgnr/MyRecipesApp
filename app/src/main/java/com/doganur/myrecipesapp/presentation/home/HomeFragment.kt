package com.doganur.myrecipesapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentHomeBinding
import com.doganur.myrecipesapp.presentation.home.categories.CategoriesAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel: HomeViewModel by viewModels()

    private val categoriesAdapter by lazy { CategoriesAdapter(::onCategoriesClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        initObservers()

        setUpOnClickListeners()
    }

    private fun setUpOnClickListeners() = with(binding) {
        imgRandomMeal.setOnClickListener {

        }
    }

    private fun setUpAdapter() = with(binding) {
        rvCategories.adapter = categoriesAdapter
    }

    private fun initObservers() = with(binding) {
        viewModel.state.observe(viewLifecycleOwner) { state ->

            progressBar.isVisible = state.isLoading

            if (state.randomMeal.isNotEmpty()) {
                Glide.with(imgRandomMeal)
                    .load(state.randomMeal.first().strMealThumb)
                    .into(imgRandomMeal)

            }

            if (state.categoriesMeal.isNotEmpty()) {
                categoriesAdapter.submitList(state.categoriesMeal)
            }
        }

        viewModel.effect.observe(viewLifecycleOwner) { effect ->
            effect?.let {
                when (effect) {
                    is HomeEffect.ShowErrorPopUp -> {
                        Snackbar.make(requireView(), effect.title, Snackbar.LENGTH_SHORT).show()
                    }

                    is HomeEffect.NavigateToCategory -> {
                        findNavController().navigate(
                            HomeFragmentDirections.homeToCategories(effect.categoryName)
                        )
                    }

                    is HomeEffect.NavigateToMealDetail -> {
                        findNavController().navigate(
                            HomeFragmentDirections.homeToMealDetail(effect.mealId)
                        )
                    }
                }
            }
        }
    }

    private fun onCategoriesClick(categoryName: String) {
        viewModel.onAction(HomeEvent.OnCategoriesClicked(categoryName))
    }

    private fun onRandomMealClick(mealId: String) {
        viewModel.onAction(HomeEvent.OnRandomMealClicked(mealId))
    }
}


