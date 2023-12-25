package com.doganur.myrecipesapp.domain.datasource.remote

import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList

interface RemoteDataSource {

    suspend fun getRandomMeal(): List<MealList>

    suspend fun getCategoriesMeal(): List<CategoryList>

    suspend fun getMostPopularMeals(categoryName: String): List<MealsByCategoryList>

    suspend fun getMealDetail(id: String): List<MealList>

    suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList>
}