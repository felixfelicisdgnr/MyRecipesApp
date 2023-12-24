package com.doganur.myrecipesapp.data.source.remote

import com.doganur.myrecipesapp.common.Constants
import com.doganur.myrecipesapp.common.Constants.GET_CATEGORIES
import com.doganur.myrecipesapp.common.Constants.GET_MEALS_BY_CATEGORY
import com.doganur.myrecipesapp.common.Constants.GET_POPUlAR_ITEMS
import com.doganur.myrecipesapp.common.Constants.GET_RANDOM_MEAL
import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {

    @GET(GET_RANDOM_MEAL)
    suspend fun getRandomMeal(): List<MealList>

    @GET(GET_CATEGORIES)
    suspend fun getCategoriesMeal(): List<CategoryList>

    @GET(GET_POPUlAR_ITEMS)
    suspend fun getMostPopularMeals( @Query("c") categoryName : String ): List<MealsByCategoryList>

    @GET(Constants.GET_MEAL_DETAILS)
    suspend fun getMealDetail(@Query("i") id: String): List<MealList>

    @GET(GET_MEALS_BY_CATEGORY)
    suspend fun getMealsByCategory(@Query("c") categoryName: String) : List<MealsByCategoryList>
}