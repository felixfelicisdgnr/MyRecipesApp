package com.doganur.myrecipesapp.db.source.remote

import com.doganur.myrecipesapp.common.Constants.GET_CATEGORIES
import com.doganur.myrecipesapp.common.Constants.GET_RANDOM_MEAL
import com.doganur.myrecipesapp.db.model.CategoryList
import com.doganur.myrecipesapp.db.model.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealApiService {

    @GET(GET_RANDOM_MEAL)
    fun getRandomMeal(): Call<MealList>

    @GET(GET_CATEGORIES)
    fun getCategoriesMeal(): Call<CategoryList>

}