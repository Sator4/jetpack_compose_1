package com.example.project_1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.project_1.model.room.ActivitiesDatabase
import com.example.project_1.model.room.Activity
import com.example.project_1.model.room.ActivityDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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