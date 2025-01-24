package com.example.project_1.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_list")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val activityType: String,
    val distance: Double,  // meters
    val usertag: String = "",
    val comment: String = "",
    val startTime: Long,
    val finishTime: Long
//    val coords: List
)