package com.doganur.myrecipesapp.domain.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.common.Resource
import com.doganur.myrecipesapp.data.model.Category
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.data.model.entity.Meal

interface MealsRepository {

    suspend fun addToFavouriteMeal(meal: Meal)

    suspend fun deleteFavouriteMeal(meal: Meal)

    suspend fun getAllFavouriteMeals(): LiveData<List<Meal>>

    suspend fun getRandomMeal(): Resource<List<Meal>>

    suspend fun getCategories(): Resource<List<Category>>

    suspend fun getMealDetail(id: String): List<MealList>

    suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList>
}