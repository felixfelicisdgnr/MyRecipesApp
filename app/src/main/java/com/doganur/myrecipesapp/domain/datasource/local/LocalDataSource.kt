package com.doganur.myrecipesapp.domain.datasource.local

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.data.model.entity.Meal

interface LocalDataSource {

    suspend fun addToFavouriteMeal(meal: Meal)

    suspend fun deleteFavouriteMeal(meal: Meal)

    suspend fun getAllFavouriteMeals(): LiveData<List<Meal>>
}