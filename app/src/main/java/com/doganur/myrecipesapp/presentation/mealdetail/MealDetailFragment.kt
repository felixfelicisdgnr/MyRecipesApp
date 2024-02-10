package com.doganur.myrecipesapp.presentation.mealdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentMealBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailFragment : Fragment(R.layout.fragment_meal) {

    private val binding by viewBinding(FragmentMealBinding::bind)

    private val mealDetailViewModel by viewModels<MealDetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        setupOnClickListeners()
    }

    private fun addToFavourite() {
        binding.btnAddToFav.setOnClickListener {

        }
    }

    private fun setupOnClickListeners() {
        binding.imgYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mealDetailViewModel.mealDetail.value?.strYoutube.toString()))
            startActivity(intent)
        }
    }

    private fun initObservers() {
        mealDetailViewModel.mealDetail.observe(viewLifecycleOwner) { meal ->
            with(binding) {

                Glide.with(imgMealDetail).load(meal?.strMealThumb).into(imgMealDetail)

                tvDetailCategories.text = meal?.strCategory
                tvDetailArea.text = meal?.strArea
                tvStepsInstructions.text = meal?.strInstructions

                collapsingToolbar.title = meal?.strMeal

            }
        }
    }
}
