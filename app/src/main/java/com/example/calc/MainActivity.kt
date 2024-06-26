package com.example.calc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.calc.data.Activity
import com.example.calc.data.ActivityViewModel
import com.example.calc.data.Event
import com.example.calc.ui.theme.CALCTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    private lateinit var mActivityViewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityViewModel = ViewModelProvider(this)[ActivityViewModel::class.java]
        setContent {
            CALCTheme {
                // A surface container using the 'background' color from the theme
                
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val activityListState = remember { mutableStateOf(emptyList<Activity>()) }
                    val eventListState = remember { mutableStateOf(emptyList<Event>()) }
                    HomeScreen(activityListState.value, eventListState.value)
                    mActivityViewModel.readAllData.observe(this, Observer { activities ->
                        activityListState.value = activities
                    })
                    mActivityViewModel.readAssignedEvents.observe(this, Observer { events ->
                        eventListState.value = events
                    })

                }
            }
        }

    }


    @Composable
    private fun SetBarColor(color: Color){
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(activities: List<Activity>, events: List<Event>){

    var selected by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar() {
                Row(
                    modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
                ) {

                    items.forEachIndexed{ index, item ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = { selected = index},
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            if (selected == 0)
            {
                WelcomeSection()
                ActivitySection(activities)
                Spacer(modifier = Modifier.height(16.dp))
                EventsSuggestionSection(events)
                ScheduleSection(events)
            }
            else if (selected == 1){
                EventPage(events)
            }
            else if (selected == 2){
                ProfilePage(events = events)
            }
        }
    }
}