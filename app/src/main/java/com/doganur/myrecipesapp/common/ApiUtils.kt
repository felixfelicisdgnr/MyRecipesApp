package com.doganur.myrecipesapp.common

import com.doganur.myrecipesapp.common.Constants.BASE_URL
import com.doganur.myrecipesapp.data.source.remote.MealService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mealService: MealService by lazy { retrofit.create(MealService::class.java) }
}