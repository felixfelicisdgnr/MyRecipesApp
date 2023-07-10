package com.doganur.myrecipesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.db.MealRepository
import com.doganur.myrecipesapp.db.model.Category
import com.doganur.myrecipesapp.db.model.Meal

class HomeViewModel : ViewModel() {

    private val mealRepository = MealRepository()

    private var _randomMealList = MutableLiveData<List<Meal>?>() //doldurdum

    private var _categoriesMealList = MutableLiveData<List<Category>?>() //doldurdum

    val randomMealList : LiveData<List<Meal>?> //dinledim
        get() = _randomMealList

    val categoriesMealList : LiveData<List<Category>?>
        get() = _categoriesMealList


   /* init {
        randomMeal()
    } */

    init {
        categoriesMeal()
    }

    /* fun randomMeal(){
        mealRepository.getRandomMeal()
        _randomMealList = mealRepository.randomMealList
    } */

    fun categoriesMeal() {
        mealRepository.getCategoriesMeal()
        _categoriesMealList = mealRepository.categoriesMealList

    }
}