package com.example.calc.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ActivityViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<Activity>>
    private val repository: ActivityRepository

    init {
        val activityDao = ActivityDatabase.getDatabase(application).activityDao()
        repository = ActivityRepository(activityDao)
        readAllData = repository.readAllData
    }
}