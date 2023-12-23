package com.doganur.myrecipesapp.data.source.local

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LocalDataSourceImpl @Inject constructor(
    private val mealDao: MealDao,
    private val ioDispatcher: CoroutineContext
) : LocalDataSource {
    override suspend fun addToFavouriteMeal(meal: Meal) = withContext(ioDispatcher) {
        mealDao.addToFavouriteMeal(meal)
    }

    override suspend fun deleteFavouriteMeal(meal: Meal) = withContext(ioDispatcher) {
        mealDao.deleteFavouriteMeal(meal)
    }

    override suspend fun getAllFavouriteMeals(): LiveData<List<Meal>> = withContext(ioDispatcher) {
        mealDao.getAllFavouriteMeal()
    }
}