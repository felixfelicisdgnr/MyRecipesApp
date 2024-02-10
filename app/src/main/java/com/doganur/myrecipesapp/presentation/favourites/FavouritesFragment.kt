package com.doganur.myrecipesapp.presentation.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentFavouritesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private val binding by viewBinding (FragmentFavouritesBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}