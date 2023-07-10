package com.doganur.myrecipesapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.FragmentHomeBinding
import com.doganur.myrecipesapp.ui.categories.CategoriesAdapter
import com.doganur.myrecipesapp.ui.mostpopular.MostPopularAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val mostPopularAdapter by lazy { MostPopularAdapter() }

    private val categoriesAdapter by lazy { CategoriesAdapter()}

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.categoriesMealList.observe(viewLifecycleOwner) {
            if (it != null) {
                categoriesAdapter.submitList(it)
                binding.rvCategories.adapter = categoriesAdapter
            } else {
                Toast.makeText(requireContext(), "Empty List !!!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}