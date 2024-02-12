package com.doganur.myrecipesapp.data.source.remote

import com.doganur.myrecipesapp.common.Constants.GET_MEAL_DETAILS
import com.doganur.myrecipesapp.data.model.Categories
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {

    @GET("categories.php")
    suspend fun getCategories(): Categories

    @GET("random.php")
    suspend fun getRandomMeal(): MealList

    @GET(GET_MEAL_DETAILS)
    suspend fun getMealDetail(@Query("i") id: String): List<MealList>

    @GET("filter.php?")
    suspend fun getMealsByCategory(@Query("c") categoryName: String): List<MealsByCategoryList>
}