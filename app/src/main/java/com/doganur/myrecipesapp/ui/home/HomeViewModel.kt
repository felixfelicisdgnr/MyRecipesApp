package com.doganur.myrecipesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.myrecipesapp.common.Resource
import com.doganur.myrecipesapp.data.model.Category
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.data.model.MealsByCategoryForPopular
import com.doganur.myrecipesapp.domain.usecase.GetCategoriesMealUseCase
import com.doganur.myrecipesapp.domain.usecase.GetMostPopularMealUseCase
import com.doganur.myrecipesapp.domain.usecase.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase,
    private val getMostPopularMealUseCase: GetMostPopularMealUseCase,
    private val getCategoriesMealUseCase: GetCategoriesMealUseCase
) : ViewModel() {

    private var _randomMeal = MutableLiveData<Resource<Meal>?>(Resource.Loading)
    val randomMeal: LiveData<Resource<Meal>?> = _randomMeal

    private var _mealsByCategoryForPopularList = MutableLiveData<Resource<List<MealsByCategoryForPopular>>?>(Resource.Loading)
    val mealsByCategoryForPopularList: LiveData<Resource<List<MealsByCategoryForPopular>>?> = _mealsByCategoryForPopularList

    private var _categoriesMealList = MutableLiveData<Resource<List<Category>>?>(Resource.Loading)
    val categoriesMealList: LiveData<Resource<List<Category>>?> = _categoriesMealList

    private var _navigateToDetail = MutableLiveData<String?>()
    val navigateToDetail: LiveData<String?> = _navigateToDetail

    init {
        randomMeal()
        popularMeal()
        categoriesMeal()
    }

    private fun randomMeal() {

    }

    private fun popularMeal() {

    }

    private fun categoriesMeal() {

    }

    fun onRandomClick() {
        //_navigateToDetail.value = randomMeal.value?.idMeal
    }

    fun setNavigateNull() {
        //_navigateToDetail.value = null
    }
}