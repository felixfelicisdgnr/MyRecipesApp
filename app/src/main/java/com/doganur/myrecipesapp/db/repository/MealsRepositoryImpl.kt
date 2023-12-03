package com.doganur.myrecipesapp.db.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.db.model.entity.Meal
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MealsRepository {
    override suspend fun addToFavouriteMeal(meal: Meal) {

    }

    override suspend fun deleteMeal(meal: Meal) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMeals(): LiveData<List<Meal>> {
        TODO("Not yet implemented")
    }
}