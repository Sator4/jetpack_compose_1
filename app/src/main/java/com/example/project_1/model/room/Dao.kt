package com.example.project_1.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    @Upsert
    suspend fun upsertActivity(activity: Activity)

    @Delete
    suspend fun deleteActivity(activity: Activity)

    @Query("SELECT * FROM activity_list")
    fun getActivities(): Flow<List<Activity>>

    @Query("SELECT * FROM activity_list WHERE id = :id")
    fun getActivityById(id: Int): Flow<Activity>
}