package com.doganur.myrecipesapp.di

import com.doganur.myrecipesapp.db.source.local.LocalDataSourceImpl
import com.doganur.myrecipesapp.db.source.local.MealDao
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
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
}