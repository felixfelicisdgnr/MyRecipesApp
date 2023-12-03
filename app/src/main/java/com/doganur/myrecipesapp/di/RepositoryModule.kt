package com.doganur.myrecipesapp.di

import com.doganur.myrecipesapp.db.repository.MealsRepositoryImpl
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductsRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): MealsRepository = MealsRepositoryImpl(localDataSource, remoteDataSource)
}