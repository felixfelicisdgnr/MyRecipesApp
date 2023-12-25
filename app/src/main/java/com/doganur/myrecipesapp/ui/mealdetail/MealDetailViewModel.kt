package com.doganur.myrecipesapp.ui.mealdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.usecase.AddToFavouriteMealUseCase
import com.doganur.myrecipesapp.domain.usecase.DeleteFavouriteMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val deleteFavoriteMealUseCase: DeleteFavouriteMealUseCase,
    private val addToFavouriteMealUseCase: AddToFavouriteMealUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _mealDetail = MutableLiveData<Meal?>() //doldurdum
    val mealDetail: LiveData<Meal?> = _mealDetail //dinledim

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite


    init {
        savedStateHandle.get<String>("mealId")?.let {
            getMealDetail(it)
        }
    }

    private fun getMealDetail(mealId: String) {
        // mealRepository.getMealDetail(mealId)
        //_mealDetail = mealRepository.mealDetail
    }

    fun addToFavouriteMeal(meal: Meal) {
        viewModelScope.launch {
            addToFavouriteMealUseCase(meal)
        }
    }

    fun deleteMeal(meal: Meal) {
        viewModelScope.launch {
            deleteFavoriteMealUseCase(meal)
        }
    }

    fun checkMealInFavourite(mealId: String) {

    }

}