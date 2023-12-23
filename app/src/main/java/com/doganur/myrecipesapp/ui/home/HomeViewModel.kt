package com.doganur.myrecipesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.data.repository.MealRepository
import com.doganur.myrecipesapp.data.model.Category
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.data.model.MealsByCategory

class HomeViewModel : ViewModel() {

    private val mealRepository = MealRepository()

    private var _randomMeal = MutableLiveData<Meal?>()
    val randomMeal: LiveData<Meal?>
        get() = _randomMeal

    private var _mealsByCategoryList = MutableLiveData<List<MealsByCategory>?>()
    val mealsByCategoryList: LiveData<List<MealsByCategory>?>
        get() = _mealsByCategoryList

    private var _categoriesMealList = MutableLiveData<List<Category>?>()
    val categoriesMealList: LiveData<List<Category>?>
        get() = _categoriesMealList

    private var _navigateToDetail = MutableLiveData<String?>()
    val navigateToDetail: LiveData<String?>
        get() = _navigateToDetail

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
        _mealsByCategoryList = mealRepository.mealsByCategoryList
    }

    private fun categoriesMeal() {
        mealRepository.getCategoriesMeal()
        _categoriesMealList = mealRepository.categoriesMealList
    }

    fun onRandomClick() {
        _navigateToDetail.value = randomMeal.value?.idMeal
    }

    fun setNavigateNull() {
        _navigateToDetail.value = null
    }
}