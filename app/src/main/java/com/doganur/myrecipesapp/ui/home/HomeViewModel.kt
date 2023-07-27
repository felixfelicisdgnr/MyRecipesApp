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

    private var _navigateToMealsByCategory = MutableLiveData<String?>()
    val navigateToMealsByCategory : LiveData<String?>
        get() = _navigateToMealsByCategory

    private var _categoryMealName = MutableLiveData<Category?>()
    val categoryMealName : LiveData<Category?>
        get() = _categoryMealName

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

    fun onMealsByCategoriesClick() {
        _navigateToMealsByCategory.value = categoryMealName.value?.strCategory//allahın cezası id ye ulaşmam lazım
    }

    fun setNavigateNull() {
        _navigateToDetail.value = null
    }
}