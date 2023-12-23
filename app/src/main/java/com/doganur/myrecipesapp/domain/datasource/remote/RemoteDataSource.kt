package com.doganur.myrecipesapp.domain.datasource.remote

import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import retrofit2.Call

interface RemoteDataSource {

    suspend fun getRandomMeal(): Call<MealList>

    suspend fun getCategoriesMeal(): Call<CategoryList>

    suspend fun getMostPopularMeals(categoryName : String): Call<MealsByCategoryList>

    suspend fun getMealDetail(id: String): Call<MealList>

    suspend fun getMealsByCategory(categoryName: String): Call<MealsByCategoryList>
}