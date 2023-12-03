package com.doganur.myrecipesapp.domain.datasource.local

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.db.model.entity.Meal

interface LocalDataSource {

    suspend fun addToFavouriteMeal(meal: Meal)

    suspend fun deleteMeal(meal: Meal)

    suspend fun getAllMeals(): LiveData<List<Meal>>
}