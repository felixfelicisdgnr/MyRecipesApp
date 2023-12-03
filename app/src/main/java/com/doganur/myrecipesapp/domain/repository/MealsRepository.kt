package com.doganur.myrecipesapp.domain.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.db.model.entity.Meal

interface MealsRepository {

    suspend fun addToFavouriteMeal(meal: Meal)

    suspend fun deleteMeal(meal: Meal)

    suspend fun getAllMeals(): LiveData<List<Meal>>
}