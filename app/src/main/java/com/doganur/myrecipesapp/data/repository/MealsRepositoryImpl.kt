package com.doganur.myrecipesapp.data.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.common.Resource
import com.doganur.myrecipesapp.data.model.Category
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MealsRepository {

    override suspend fun getRandomMeal(): Resource<List<Meal>> {
        return try {
            val response = remoteDataSource.getRandomMeal()
            Resource.Success(response.meals)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun getCategories(): Resource<List<Category>> {
        return try {
            val response = remoteDataSource.getCategories()
            Resource.Success(response.categories)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun getMealDetail(id: String): List<MealList> {
        return remoteDataSource.getMealDetail(id)
    }

    override suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList> {
        return remoteDataSource.getMealsByCategory(categoryName)
    }

    override suspend fun getAllFavouriteMeals(): LiveData<List<Meal>> = localDataSource.getAllFavouriteMeals()

    override suspend fun addToFavouriteMeal(meal: Meal) = localDataSource.addToFavouriteMeal(meal)

    override suspend fun deleteFavouriteMeal(meal: Meal) = localDataSource.deleteFavouriteMeal(meal)
}