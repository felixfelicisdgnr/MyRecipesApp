package com.doganur.myrecipesapp.ui.categorymeals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.db.MealRepository
import com.doganur.myrecipesapp.db.model.MealsByCategory

class CategoryMealsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val mealRepository = MealRepository()

    private var _mealsByCategoryDetailList = MutableLiveData<List<MealsByCategory>?>()
    val mealsByCategoryDetailList : LiveData<List<MealsByCategory>?>
        get() = _mealsByCategoryDetailList

    init {
        savedStateHandle.get<String>("mealsByCategoryDetailId")?.let {
            getCategoriesDetailMeal(it)
        }
    }

    private fun getCategoriesDetailMeal(mealsByCategoryDetailId : String) {
        mealRepository.getMealsByCategory(mealsByCategoryDetailId)
        _mealsByCategoryDetailList = mealRepository.mealsByCategoryList
    }

}