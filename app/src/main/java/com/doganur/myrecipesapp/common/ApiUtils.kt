package com.doganur.myrecipesapp.common

import com.doganur.myrecipesapp.db.source.remote.MealApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mealApiService: MealApiService by lazy { retrofit.create(MealApiService::class.java) }

}