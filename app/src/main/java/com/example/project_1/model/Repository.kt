package com.example.project_1.model

import com.example.project_1.model.room.Activity
import com.example.project_1.model.room.ActivityDao
import kotlinx.coroutines.flow.Flow

class Repository (
    private val activityDao: ActivityDao
){
    suspend fun upsertActivity(activity: Activity) =
        activityDao.upsertActivity(activity)

    suspend fun deleteActivity(activity: Activity) =
        activityDao.deleteActivity(activity)

    fun getActivities(): Flow<List<Activity>> =
        activityDao.getActivities()

    fun getActivityById(id: Int): Flow<Activity> =
        activityDao.getActivityById(id)
}