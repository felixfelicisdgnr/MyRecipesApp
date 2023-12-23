package com.doganur.myrecipesapp.data.source.remote

import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import retrofit2.Call
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val mealService: MealService
) : RemoteDataSource {
    override suspend fun getRandomMeal(): Call<MealList> = mealService.getRandomMeal()

    override suspend fun getCategoriesMeal(): Call<CategoryList> = mealService.getCategoriesMeal()

    override suspend fun getMostPopularMeals(categoryName: String): Call<MealsByCategoryList> =
        mealService.getMostPopularMeals(categoryName)

    override suspend fun getMealDetail(id: String): Call<MealList> = mealService.getMealDetail(id)

    override suspend fun getMealsByCategory(categoryName: String): Call<MealsByCategoryList> =
        mealService.getMealsByCategory(categoryName)
}