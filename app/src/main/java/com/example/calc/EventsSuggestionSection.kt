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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.data.Activity
import com.example.calc.data.Event
import com.example.calc.ui.theme.DarkGreen
import com.example.calc.ui.theme.Green


@Composable
fun EventsSuggestionSection(events: List<Event>){
    Column {
        Text(
            text = "События",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow {
            items(events.size){ index ->
                SuggestionCard(events[index])
            }
        }
    }
}

@Composable
fun SuggestionCard(
    event: Event
) {
    Box(modifier = Modifier.padding(start = 12.dp, end = 8.dp))
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(getGradient(Green, DarkGreen))
                .width(250.dp)
                .height(240.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Icon(
                imageVector = event.eventIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = event.eventName,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )


            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Время проведения ${event.eventStartTime}-${event.eventEndTime}",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                style = TextStyle(
                    lineHeight = 18.sp
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(modifier = Modifier
                .height(40.dp)
                .width(150.dp),
                shape = RoundedCornerShape(4.dp),
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.Yellow
                ),
                onClick = { /*TODO*/ }) {
                Text(text = "Записаться")
            }
        }
    }
}