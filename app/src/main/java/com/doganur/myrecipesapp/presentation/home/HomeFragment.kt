package com.doganur.myrecipesapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentHomeBinding
import com.doganur.myrecipesapp.presentation.categories.CategoriesAdapter
import com.doganur.myrecipesapp.presentation.mostpopular.MostPopularAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val homeViewModel: HomeViewModel by viewModels()

    private val mostPopularAdapter by lazy { MostPopularAdapter(::onPopularClick) }

    private val categoriesAdapter by lazy { CategoriesAdapter(::onCategoriesClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun onPopularClick(string: String) {

    }

    private fun onCategoriesClick(string: String) {

    }
}


