package com.doganur.myrecipesapp.di

import com.doganur.myrecipesapp.data.source.local.LocalDataSourceImpl
import com.doganur.myrecipesapp.data.source.local.MealDao
import com.doganur.myrecipesapp.data.source.remote.MealService
import com.doganur.myrecipesapp.data.source.remote.RemoteDataSourceImpl
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(
        productFavoriteDAO: MealDao,
        ioDispatcher: CoroutineContext
    ): LocalDataSource = LocalDataSourceImpl(productFavoriteDAO, ioDispatcher)

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        mealService: MealService
    ): RemoteDataSource = RemoteDataSourceImpl(mealService)
}