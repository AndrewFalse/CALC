package com.example.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalActivity
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calc.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Главная",
        icon = Icons.Rounded.Home,
        route = "main"
    ),

    BottomNavigation(
        title = "События",
        icon = Icons.Rounded.LocalActivity,
        route = "events"
    ),

    BottomNavigation(
        title = "Профиль",
        icon = Icons.Rounded.AccountCircle,
        route = "profile"
    )
)