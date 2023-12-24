package com.doganur.myrecipesapp.data.repository

class MealRepository {

    /* private val service = ApiUtils.mealService

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

                randomMeal.value =  meals?.random()
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

                categoriesMealList.value = categories
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

                mealsByCategoryList.value =  popularMeals
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

                mealsByCategoryList.value = categoriesMealsDetails
            }

            override fun onFailure(call: Call<MealsByCategoryList>, t: Throwable) {
                Log.d("Failure Popular Meals", t.message.orEmpty())
            }
        })
    } */
}