package com.doganur.myrecipesapp.presentation.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private val binding by viewBinding (FragmentCategoriesBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}