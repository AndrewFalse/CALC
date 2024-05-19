package com.example.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BikeScooter
import androidx.compose.material.icons.rounded.GolfCourse
import androidx.compose.material.icons.rounded.Pool
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.calc.data.Activity
import com.example.calc.data.ActivityViewModel
import com.example.calc.ui.theme.Blue
import com.example.calc.ui.theme.DarkBlue
import com.example.calc.ui.theme.DarkGreen
import com.example.calc.ui.theme.DarkOrange
import com.example.calc.ui.theme.Green
import com.example.calc.ui.theme.Orange


fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return  Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun ActivitySection(activities: List<Activity>){
    Column {
        Text(
            text = "Новинки",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow {
            items(activities.size){ index ->
                ActivityCard(activities[index])
            }
        }
    }
}

@Composable
fun ActivityCard(
    activity: Activity
) {
    Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp))
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(getGradient(Green, DarkGreen))
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Icon(
                imageVector = activity.activityIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = activity.activityName,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = activity.activityDescription,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                style = TextStyle(
                    lineHeight = 18.sp
                )
            )
        }
    }
}

