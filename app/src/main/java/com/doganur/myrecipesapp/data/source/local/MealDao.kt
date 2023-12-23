package com.doganur.myrecipesapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.doganur.myrecipesapp.data.model.entity.Meal

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavouriteMeal(meal: Meal)

    @Delete
    fun deleteFavouriteMeal(meal: Meal)

    @Query("SELECT * FROM mealInformation")
    fun getAllFavouriteMeal(): LiveData<List<Meal>>
}