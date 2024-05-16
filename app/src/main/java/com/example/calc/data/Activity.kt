package com.example.calc.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class Activity(
    val activityIcon: ImageVector,
    val activityName: String,
    val activityDescription: String,
    val color: Brush
)
