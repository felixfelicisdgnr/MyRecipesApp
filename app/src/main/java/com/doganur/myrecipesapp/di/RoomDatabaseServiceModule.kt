package com.doganur.myrecipesapp.di

import android.content.Context
import androidx.room.Room
import com.doganur.myrecipesapp.data.source.local.LocalDatabaseService
import com.doganur.myrecipesapp.data.source.local.MealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseServiceModule {

    @Provides
    @Singleton
    fun provideFavoritesRoomDB(@ApplicationContext context: Context): LocalDatabaseService =
        Room.databaseBuilder(
            context,
            LocalDatabaseService::class.java,
            "mealdetail.data"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideProductFavoriteDAO(favoritesRoomDB: LocalDatabaseService): MealDao =
        favoritesRoomDB.mealDao()
}