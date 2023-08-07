package com.doganur.myrecipesapp.db

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.doganur.myrecipesapp.common.ApiUtils
import com.doganur.myrecipesapp.db.model.Category
import com.doganur.myrecipesapp.db.model.CategoryList
import com.doganur.myrecipesapp.db.model.Meal
import com.doganur.myrecipesapp.db.model.MealList
import com.doganur.myrecipesapp.db.model.MealsByCategory
import com.doganur.myrecipesapp.db.model.MealsByCategoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository {

    private val service = ApiUtils.mealApiService

    val randomMeal = MutableLiveData<Meal?>()
    val categoriesMealList = MutableLiveData<List<Category>?>()
    val mealsByCategoryList = MutableLiveData<List<MealsByCategory>?>()
    val mealDetail = MutableLiveData<Meal?>()

    fun getRandomMeal() {
        service.getRandomMeal().enqueue(object : Callback<MealList> {
            override fun onResponse(
                call: Call<MealList>, response: Response<MealList>
            ) {
                val meals = response.body()?.meals

                randomMeal.value = if (meals.isNullOrEmpty()) null else meals.random()
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Failure Random Meals", t.message.orEmpty())
            }
        })
    }

    fun getCategoriesMeal() {
        service.getCategoriesMeal().enqueue(object : Callback<CategoryList> {
            override fun onResponse(
                call: Call<CategoryList>, response: Response<CategoryList>
            ) {
                val categories = response.body()?.categories

                categoriesMealList.value = if (categories.isNullOrEmpty()) null else categories
            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d("Failure Categories", t.message.orEmpty())
            }
        })
    }

    fun getPopularMeal() {
        service.getMostPopularMeals("Seafood").enqueue(object : Callback<MealsByCategoryList> {
            override fun onResponse(
                call: Call<MealsByCategoryList>, response: Response<MealsByCategoryList>
            ) {
                val popularMeals = response.body()?.meals

                mealsByCategoryList.value = if (popularMeals.isNullOrEmpty()) null else popularMeals
            }

            override fun onFailure(call: Call<MealsByCategoryList>, t: Throwable) {
                Log.d("failure Popular Meals", t.message.orEmpty())
            }
        })
    }

    fun getMealDetail(id: String) {
        service.getMealDetail(id).enqueue(object : Callback<MealList> {
            override fun onResponse(
                call: Call<MealList>, response: Response<MealList>
            ) {
                val meals = response.body()?.meals

                mealDetail.value = meals?.firstOrNull()
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("failure Popular Meals", t.message.orEmpty())
            }
        })
    }

    fun getMealsByCategory(categoryName : String) {
        service.getMealsByCategory(categoryName).enqueue(object : Callback<MealsByCategoryList>{
            override fun onResponse(
                call: Call<MealsByCategoryList>,
                response: Response<MealsByCategoryList>
            ) {
                val categoriesMealsDetails = response.body()?.meals

                mealsByCategoryList.value = if (categoriesMealsDetails.isNullOrEmpty()) null else categoriesMealsDetails
            }

            override fun onFailure(call: Call<MealsByCategoryList>, t: Throwable) {
                Log.d("Failure Popular Meals", t.message.orEmpty())
            }
        })
    }
}