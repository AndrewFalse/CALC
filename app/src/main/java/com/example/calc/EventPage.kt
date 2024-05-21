package com.example.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.calc.data.Activity
import com.example.calc.data.Event
import com.example.calc.ui.theme.Green

@Composable
fun EventPage(events: List<Event>) {
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(start = 12.dp, end = 12.dp)) {

        Text(
            text = "События",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )

        LazyColumn(modifier = Modifier.height(660.dp)){
            items(events.size){ index ->
                EventCard(events[index])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(modifier = Modifier
            .height(50.dp)
            .width(400.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = Color.White
            ),
            onClick = { showDialog = true }) {
            Text(
                text = "Добавить событие",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }

        if (showDialog) {
            Dialog(
                onDismissRequest = { showDialog = false }
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .width(650.dp)
                        .height(650.dp)
                ) {
                    EventAddPage(
                        onDismiss = { showDialog = false }
                    )
                }
            }
        }
    }
}

@Composable
fun EventCard(
    event: Event
) {
    var showEditDialog by remember { mutableStateOf(false) }
    Box(modifier = Modifier.padding( top = 8.dp))
    {
        val (startColor, endColor) = getNextColorPair()
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(getGradient(startColor, endColor))
                .width(400.dp)
                .height(150.dp)
                .clickable { showEditDialog = true}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = event.eventIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column() {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = event.eventName,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = event.eventDescription,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    style = TextStyle(
                        lineHeight = 18.sp
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Время проведения ${event.eventStartTime}-${event.eventEndTime}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = TextStyle(
                        lineHeight = 18.sp
                    )
                )
            }

        }

        if (showEditDialog) {
            Dialog(
                onDismissRequest = { showEditDialog = false }
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .width(650.dp)
                        .height(650.dp)
                ) {
                    EventEditPage(
                        onDismiss = { showEditDialog = false },
                        event
                    )
                }
            }
        }
    }
}
