package com.doganur.myrecipesapp.domain.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.data.model.entity.Meal
import retrofit2.Call

interface MealsRepository {

    suspend fun addToFavouriteMeal(meal: Meal)

    suspend fun deleteFavouriteMeal(meal: Meal)

    suspend fun getAllFavouriteMeals(): LiveData<List<Meal>>

    suspend fun getRandomMeal(): List<MealList>

    suspend fun getCategoriesMeal(): List<CategoryList>

    suspend fun getMostPopularMeals(categoryName : String): List<MealsByCategoryList>

    suspend fun getMealDetail(id: String): List<MealList>

    suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList>
}