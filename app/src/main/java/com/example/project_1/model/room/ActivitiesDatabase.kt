package com.example.project_1.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Activity::class],
    version = 1,
    exportSchema = false
)
abstract class ActivitiesDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao

    companion object {
        @Volatile
        var INSTANCE: ActivitiesDatabase? = null
        fun getDatabase(context: Context): ActivitiesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ActivitiesDatabase::class.java,
                    "activities_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}