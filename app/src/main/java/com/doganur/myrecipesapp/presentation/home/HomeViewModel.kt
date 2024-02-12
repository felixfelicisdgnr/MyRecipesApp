package com.doganur.myrecipesapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.myrecipesapp.common.Resource
import com.doganur.myrecipesapp.data.model.Category
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.usecase.GetCategoriesUseCase
import com.doganur.myrecipesapp.domain.usecase.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {

    var state: MutableLiveData<HomeUIState> = MutableLiveData(HomeUIState(isLoading = true))
        private set

    var effect: MutableLiveData<HomeEffect?> = MutableLiveData()
        private set

    init {
        getRandomMeal()
    }

    fun onAction(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnCategoriesClicked -> {
                effect.value = HomeEffect.NavigateToCategory(event.categoryName)
            }
            is HomeEvent.OnRandomMealClicked -> {
                effect.value = HomeEffect.NavigateToMealDetail(event.mealId)
            }
        }
        effect.value = null
    }

    private fun getRandomMeal() = viewModelScope.launch {
        when (val resource = getRandomMealUseCase()) {
            is Resource.Success -> {
                state.value = state.value?.copy(randomMeal = resource.data)
                getCategories()
            }

            is Resource.Error -> {
                state.value = state.value?.copy(isLoading = false)
                effect.value = HomeEffect.ShowErrorPopUp("Error", "An error occurred")
            }
        }
    }

    private fun getCategories() = viewModelScope.launch {
        when (val resource = getCategoriesUseCase()) {
            is Resource.Success -> {
                state.value = state.value?.copy(categoriesMeal = resource.data, isLoading = false)
            }

            is Resource.Error -> {
                state.value = state.value?.copy(isLoading = false)
                effect.value = HomeEffect.ShowErrorPopUp("Error", "An error occurred")
            }
        }
    }
}

data class HomeUIState(
    val isLoading: Boolean = false,
    val randomMeal: List<Meal> = emptyList(),
    val categoriesMeal: List<Category> = emptyList()
)

sealed interface HomeEffect {
    data class ShowErrorPopUp(val title: String, val desc: String) : HomeEffect
    data class NavigateToCategory(val categoryName: String) : HomeEffect
    data class NavigateToMealDetail(val mealId: String) : HomeEffect
}

sealed interface HomeEvent {
    data class OnCategoriesClicked(val categoryName: String) : HomeEvent
    data class OnRandomMealClicked(val mealId: String) : HomeEvent
}