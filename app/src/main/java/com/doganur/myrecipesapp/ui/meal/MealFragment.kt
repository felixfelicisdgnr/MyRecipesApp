package com.doganur.myrecipesapp.ui.meal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentMealBinding


class MealFragment : Fragment(R.layout.fragment_meal) {

    private val binding by viewBinding(FragmentMealBinding::bind)

    private val mealViewModel by viewModels<MealViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* binding.imgYoutube.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(meal?.strYoutube.toString()))
                    startActivity(intent)
          } */

        initObservers()
    }

    private fun initObservers() {

        with(binding) {
            mealViewModel.mealDetail.observe(viewLifecycleOwner) { meal ->

                Glide.with(imgMealDetail).load(meal?.strMealThumb).into(imgMealDetail)

                tvDetailCategories.text = meal?.strCategory
                tvDetailArea.text = meal?.strArea
                tvStepsInstructions.text = meal?.strInstructions

                collapsingToolbar.title = meal?.strMeal
                collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.white))
                collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.white))

            }
        }
    }
}
