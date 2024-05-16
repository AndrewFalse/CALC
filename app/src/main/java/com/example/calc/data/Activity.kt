package com.example.calc.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Emergency
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities")
data class Activity(
    var activityIcon: ImageVector,
    var activityName: String,
    var activityDescription: String,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {
    constructor(): this(Icons.Rounded.Emergency, "", "")
}
