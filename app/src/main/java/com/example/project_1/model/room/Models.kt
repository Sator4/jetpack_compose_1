package com.example.project_1.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_list")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val activityType: String,
    val distance: String,
    val time: String,
    val date: String,
    val usertag: String? = null,
    val comment: String = "",
    val startTime: String = "00:00:00",
    val finishTime: String = "00:00:00"
//    val coords: List
)