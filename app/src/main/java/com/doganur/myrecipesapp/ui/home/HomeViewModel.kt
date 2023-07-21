package com.doganur.myrecipesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.db.MealRepository
import com.doganur.myrecipesapp.db.model.Category
import com.doganur.myrecipesapp.db.model.Meal
import com.doganur.myrecipesapp.db.model.MealsByCategory

class HomeViewModel : ViewModel() {

    private val mealRepository = MealRepository()

    private var _randomMeal = MutableLiveData<Meal?>() //doldurdum

    private var _popularMealList = MutableLiveData<List<MealsByCategory>?>()

    private var _categoriesMealList = MutableLiveData<List<Category>?>() //doldurdum

    val randomMeal: LiveData<Meal?> //dinledim
        get() = _randomMeal

    val popularMealList: LiveData<List<MealsByCategory>?>
        get() = _popularMealList

    val categoriesMealList: LiveData<List<Category>?>
        get() = _categoriesMealList

    init {
        randomMeal()
        popularMeal()
        categoriesMeal()
    }

    private fun randomMeal() {
        mealRepository.getRandomMeal()
        _randomMeal = mealRepository.randomMeal
    }

    private fun popularMeal() {
        mealRepository.getPopularMeal()
        _popularMealList = mealRepository.popularMealMutableList
    }

    private fun categoriesMeal() {
        mealRepository.getCategoriesMeal()
        _categoriesMealList = mealRepository.categoriesMealList
    }
}