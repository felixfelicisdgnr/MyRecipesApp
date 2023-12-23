package com.doganur.myrecipesapp.data.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import retrofit2.Call
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MealsRepository {

    override suspend fun getRandomMeal(): Call<MealList> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoriesMeal(): Call<CategoryList> {
        TODO("Not yet implemented")
    }

    override suspend fun getMostPopularMeals(categoryName: String): Call<MealsByCategoryList> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealDetail(id: String): Call<MealList> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealsByCategory(categoryName: String): Call<MealsByCategoryList> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavouriteMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavouriteMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFavouriteMeals(): LiveData<List<Meal>> {
        TODO("Not yet implemented")
    }
}