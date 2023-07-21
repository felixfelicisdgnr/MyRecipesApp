package com.doganur.myrecipesapp.ui.meal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentMealBinding


class MealFragment : Fragment(R.layout.fragment_meal) {

    private val binding by viewBinding(FragmentMealBinding::bind)

    private val mealViewModel by viewModels<MealViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }

        initObservers()
    }

    private fun initObservers() {
        mealViewModel.mealDetail.observe(viewLifecycleOwner) { meal ->
            binding.collapsingToolbar.title = meal?.strMeal
        }
    }
}
