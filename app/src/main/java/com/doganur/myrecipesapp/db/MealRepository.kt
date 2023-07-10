package com.doganur.myrecipesapp.db

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.doganur.myrecipesapp.common.ApiUtils
import com.doganur.myrecipesapp.db.model.Category
import com.doganur.myrecipesapp.db.model.CategoryList
import com.doganur.myrecipesapp.db.model.Meal
import com.doganur.myrecipesapp.db.model.MealList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository {

    private val service = ApiUtils.mealApiService

    val randomMealList = MutableLiveData<List<Meal>?>()

    val categoriesMealList = MutableLiveData<List<Category>?>()

    /*fun getRandomMeal() {
        service.getRandomMeal().enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body()?.dataMealList.isNullOrEmpty()) {
                    randomMealList.value = null
                } else {
                    randomMealList.value = response.body()?.dataMealList
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }

        })
    }*/

    fun getCategoriesMeal() {
        service.getCategoriesMeal().enqueue(object : Callback<CategoryList> {
            override fun onResponse(
                call: Call<CategoryList>,
                response: Response<CategoryList>
            ) {
               if(response.body()?.dataCategoryList.isNullOrEmpty()) {
                   categoriesMealList.value = null
               } else {
                   categoriesMealList.value = response.body()!!.dataCategoryList
                   Log.d("TEST","meal id ${response.body()!!.dataCategoryList} ")
                   println(categoriesMealList.value)
               }
            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.d("Failure CATEGORIES", t.message.orEmpty())
                println("zortzort")
            }
        })
    }
}