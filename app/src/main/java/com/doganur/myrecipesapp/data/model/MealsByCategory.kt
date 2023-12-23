package com.doganur.myrecipesapp.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealsByCategory(
    val idMeal: String?,
    val strMeal: String?,
    val strMealThumb: String?
) : Parcelable