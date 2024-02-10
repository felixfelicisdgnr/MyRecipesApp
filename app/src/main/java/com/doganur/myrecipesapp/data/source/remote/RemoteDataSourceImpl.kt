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
    override suspend fun getRandomMeal(): List<MealList> = mealService.getRandomMeal()

    override suspend fun getCategoriesMeal(): List<CategoryList> = mealService.getCategoriesMeal()

    override suspend fun getMostPopularMeals(categoryName: String): List<MealsByCategoryList> =
        mealService.getMostPopularMeals(categoryName)

    override suspend fun getMealDetail(id: String): List<MealList> = mealService.getMealDetail(id)

    override suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList> =
        mealService.getMealsByCategory(categoryName)
}