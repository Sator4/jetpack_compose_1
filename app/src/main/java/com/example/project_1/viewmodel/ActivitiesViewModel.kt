package com.example.project_1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_1.model.room.Activity
import com.example.project_1.model.room.ActivityDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivitiesViewModel @Inject internal constructor(
    private val activityDao: ActivityDao
) : ViewModel() {
    fun activities() = activityDao.getActivities()

    fun getActivity(activityId: Int) = activityDao.getActivityById(activityId)

    fun addActivity(newActivity: Activity){
        viewModelScope.launch {
            activityDao.upsertActivity(newActivity)
        }
    }

    fun deleteActivity(activity: Activity){
        viewModelScope.launch {
            activityDao.deleteActivity(activity)
        }
    }


}