package com.example.calc.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Emergency
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date

@Entity(tableName = "events")
data class Event(
    var eventName: String,
    var eventIcon: ImageVector,
    var eventDescription: String,
    val eventStartTime: String,
    val eventEndTime: String,
    val eventAssigned: Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {
    constructor(): this("", Icons.Rounded.Emergency, "", "", "", 0)
}