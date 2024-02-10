package com.doganur.myrecipesapp.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.doganur.myrecipesapp.R
import com.doganur.myrecipesapp.common.viewBinding
import com.doganur.myrecipesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        NavigationUI.setupWithNavController(binding.btnNav, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination_, _ ->

            when (destination_.id) {
                R.id.homeFragment,
                R.id.favouritesFragment,
                R.id.categoriesFragment -> {
                    binding.btnNav.isGone = false
                } else -> {
                    binding.btnNav.isGone = true
                }
            }
        }
    }
}