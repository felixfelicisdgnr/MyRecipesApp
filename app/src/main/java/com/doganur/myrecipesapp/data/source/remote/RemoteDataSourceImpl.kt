package com.doganur.myrecipesapp.data.source.remote

import com.doganur.myrecipesapp.data.model.Categories
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val mealService: MealService
) : RemoteDataSource {

    override suspend fun getRandomMeal(): MealList = mealService.getRandomMeal()

    override suspend fun getCategories(): Categories = mealService.getCategories()

    override suspend fun getMealDetail(id: String): List<MealList> = mealService.getMealDetail(id)

    override suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList> =
        mealService.getMealsByCategory(categoryName)
}