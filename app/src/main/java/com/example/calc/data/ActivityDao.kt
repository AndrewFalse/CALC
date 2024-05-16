package com.example.calc.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ActivityDao {

    @Query("SELECT * FROM activities ORDER BY id ASC")
    fun readAllData(): LiveData<List<Activity>>

}