package com.doganur.myrecipesapp.domain.usecase

import com.doganur.myrecipesapp.domain.repository.MealsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetRandomMealUseCase @Inject constructor(
    private val mealsRepository: MealsRepository
) {

}