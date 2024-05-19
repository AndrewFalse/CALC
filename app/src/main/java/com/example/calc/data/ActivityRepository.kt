package com.example.calc.data

import androidx.lifecycle.LiveData

class ActivityRepository(private val activityDao: ActivityDao) {

    val readAllData: LiveData<List<Activity>> = activityDao.readAllData()
    val readAllEventData: LiveData<List<Event>> = activityDao.readAllEventData()
    val readAssignedEvents: LiveData<List<Event>> = activityDao.readAssignedEvents()

}