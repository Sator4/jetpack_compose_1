package com.example.project_1

import android.content.Context
import com.example.project_1.model.room.ActivitiesDatabase
import com.example.project_1.model.room.ActivityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ActivitiesDatabase {
        return ActivitiesDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideDao(database: ActivitiesDatabase): ActivityDao {
        return database.activityDao()
    }
}