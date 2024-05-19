package com.example.calc.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ActivityDao {

    @Query("SELECT * FROM activities ORDER BY id ASC")
    fun readAllData(): LiveData<List<Activity>>

    @Query("SELECT * FROM events ORDER BY id ASC LIMIT 5")
    fun readAllEventData(): LiveData<List<Event>>

    @Query("SELECT * FROM events WHERE eventAssigned = 1")
    fun readAssignedEvents(): LiveData<List<Event>>

}