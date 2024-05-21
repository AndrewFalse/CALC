package com.example.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.data.Event
import com.example.calc.ui.theme.Blue
import com.example.calc.ui.theme.Orange


@Composable
fun ProfilePage(events: List<Event>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Пользователь",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.secondaryContainer).clickable {  }.padding(6.dp).size(40.dp).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Rounded.Face,
                    contentDescription = "Profile",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                modifier = Modifier.width(160.dp),
                text = "Расписание",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                modifier = androidx.compose.ui.Modifier.width(75.dp),
                text = "Начало",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End
            )


            Text(
                modifier = androidx.compose.ui.Modifier.width(75.dp),
                text = "Конец",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End
            )

            Text(
                modifier = androidx.compose.ui.Modifier.width(80.dp),
                text = "Удалить",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(events.size) { index ->
                EventItemP(
                    events[index],
                )
            }
        }

        Spacer(modifier = Modifier.height(340.dp))

        Button(modifier = Modifier
            .height(40.dp)
            .width(400.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            onClick = { }) {
            Text(
                text = "Выйти",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }

    }
}

@Composable
fun EventItemP(event: Event) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(180.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Blue)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = event.eventIcon,
                    contentDescription = event.eventName,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = event.eventName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Text(
            modifier = Modifier
                .width(80.dp)
                .padding(start = 4.dp),
            text = event.eventStartTime,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        Text(
            modifier = Modifier
                .width(80.dp)
                .padding(start = 4.dp),
            text = event.eventEndTime,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = Icons.Rounded.Cancel,
            contentDescription = "event.eventName",
            tint = Color.Red
        )

    }
}