package com.doganur.myrecipesapp.domain.usecase

import com.doganur.myrecipesapp.domain.repository.MealsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetAllMealUseCase @Inject constructor(
    private val mealsRepository: MealsRepository
) {

    suspend operator fun invoke() = mealsRepository.getAllFavouriteMeals()
}