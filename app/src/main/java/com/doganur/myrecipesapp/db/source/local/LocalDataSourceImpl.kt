package com.doganur.myrecipesapp.db.source.local

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.db.model.entity.Meal
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

    override suspend fun deleteMeal(meal: Meal) = withContext(ioDispatcher) {
        mealDao.deleteMeal(meal)
    }

    override suspend fun getAllMeals(): LiveData<List<Meal>> = withContext(ioDispatcher) {
        mealDao.getAllMeals()
    }
}