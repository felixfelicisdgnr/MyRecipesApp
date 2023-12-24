package com.doganur.myrecipesapp.domain.usecase

import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteFavouriteMealUseCase @Inject constructor(
    private val mealsRepository: MealsRepository
) {
    suspend operator fun invoke(mealId: Meal) {
        mealsRepository.deleteFavouriteMeal(mealId)
    }
}