package com.example.calc.data

import androidx.lifecycle.LiveData

class ActivityRepository(private val activityDao: ActivityDao) {

    val readAllData: LiveData<List<Activity>> = activityDao.readAllData()

}