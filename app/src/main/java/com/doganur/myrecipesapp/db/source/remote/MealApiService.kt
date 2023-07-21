package com.doganur.myrecipesapp.db.source.remote

import com.doganur.myrecipesapp.common.Constants
import com.doganur.myrecipesapp.common.Constants.GET_CATEGORIES
import com.doganur.myrecipesapp.common.Constants.GET_POPUlAR_ITEMS
import com.doganur.myrecipesapp.common.Constants.GET_RANDOM_MEAL
import com.doganur.myrecipesapp.db.model.CategoryList
import com.doganur.myrecipesapp.db.model.MealList
import com.doganur.myrecipesapp.db.model.MealsByCategoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    @GET(GET_RANDOM_MEAL)
    fun getRandomMeal(): Call<MealList>

    @GET(GET_CATEGORIES)
    fun getCategoriesMeal(): Call<CategoryList>

    @GET(GET_POPUlAR_ITEMS)
    fun getMostPopularMeals( @Query("c") categoryName : String ): Call<MealsByCategoryList>

    @GET(Constants.GET_MEAL_DETAILS)
    fun getMealDetail(@Query("i") id: String): Call<MealList>

}