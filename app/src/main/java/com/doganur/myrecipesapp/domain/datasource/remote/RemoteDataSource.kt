package com.doganur.myrecipesapp.domain.datasource.remote

import com.doganur.myrecipesapp.data.model.Categories
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList

interface RemoteDataSource {

    suspend fun getRandomMeal(): MealList

    suspend fun getCategories(): Categories

    suspend fun getMealDetail(id: String): List<MealList>

    suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList>
}