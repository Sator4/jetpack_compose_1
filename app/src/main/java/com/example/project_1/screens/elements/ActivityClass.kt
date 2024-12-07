package com.example.project_1.screens.elements

import kotlinx.serialization.Serializable

//@Serializable
data class ActivityClass(
    val distance: String,
    val time: String,
    val activity: String,
    val date: String,
    val usertag: String? = null,
    val start_time: String = "",
    val finish_time: String = "",
    val comment: String = ""
)