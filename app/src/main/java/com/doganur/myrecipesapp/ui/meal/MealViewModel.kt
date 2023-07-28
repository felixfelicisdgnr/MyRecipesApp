package com.doganur.myrecipesapp.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.db.MealRepository
import com.doganur.myrecipesapp.db.model.Meal

class MealViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val mealRepository = MealRepository()

    private var _mealDetail = MutableLiveData<Meal?>() //doldurdum
    val mealDetail: LiveData<Meal?> //dinledim
        get() = _mealDetail



    init {
        savedStateHandle.get<String>("mealId")?.let {
            getMealDetail(it)
        }
    }

    private fun getMealDetail(mealId: String) {
        mealRepository.getMealDetail(mealId)
        _mealDetail = mealRepository.mealDetail
    }


}