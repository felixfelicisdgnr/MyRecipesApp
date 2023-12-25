package com.doganur.myrecipesapp.ui.mealcategories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.data.model.MealsByCategoryForPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealCategoriesViewModel @Inject constructor(

    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private var _mealsByCategoryForPopularDetailList = MutableLiveData<List<MealsByCategoryForPopular>?>()
    val mealsByCategoryForPopularDetailList : LiveData<List<MealsByCategoryForPopular>?> = _mealsByCategoryForPopularDetailList

    init {
        savedStateHandle.get<String>("categoriesId")?.let {
            getCategoriesMeal(it)
        }
    }

    private fun getCategoriesMeal(mealsByCategoryDetailId : String) {
        //mealRepository.getMealsByCategory(mealsByCategoryDetailId)
        //_MealsByCategoryForPopularDetailList = mealRepository.mealsByCategoryList
    }
}