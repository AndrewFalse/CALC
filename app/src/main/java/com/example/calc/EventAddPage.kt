package com.example.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountTree
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.BikeScooter
import androidx.compose.material.icons.rounded.BreakfastDining
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Spa
import androidx.compose.material.icons.rounded.SportsTennis
import androidx.compose.material.icons.rounded.Terrain
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.calc.ui.theme.Green
import com.example.calc.ui.theme.Orange
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventAddPage() {
    var activityName by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var startTime by remember { mutableStateOf(TextFieldValue("")) }
    var endTime by remember { mutableStateOf(TextFieldValue("")) }
    var selectedIcon by remember { mutableStateOf<Icons.Rounded?>(null) }
    var showIconDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Новое событие", fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Наименование", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = activityName,
            onValueChange = { activityName = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Green,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Blue,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Описание", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = description,
            onValueChange = { activityName = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Green,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Blue,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Время начала", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = startTime,
            onValueChange = { activityName = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Green,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Blue,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Время завершения", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = endTime,
            onValueChange = { activityName = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Green,
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Blue,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Иконка события", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
        Spacer(modifier = Modifier.height(8.dp))
        IconSelectorExample()

        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier
            .height(40.dp)
            .width(400.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Добавить",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }
    }
}

@Composable
fun IconSelectorExample() {
    var selectedIcon by remember { mutableStateOf<ImageVector?>(null) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconSelector(
            onIconSelected = { icon ->
                selectedIcon = icon
            }
        )
    }
}


@Composable
fun IconSelector(onIconSelected: (ImageVector) -> Unit) {
    val icons = listOf(
        Icons.Rounded.BreakfastDining,
        Icons.Rounded.LunchDining,
        Icons.Rounded.Spa,
        Icons.Rounded.SportsTennis,
        Icons.Rounded.BikeScooter,
        Icons.Rounded.Terrain
    )

    var selectedIcon by remember { mutableStateOf<ImageVector?>(null) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        items(icons) { icon ->
            val isSelected = selectedIcon == icon
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(6.dp)
                    .clickable {
                        selectedIcon = icon
                        onIconSelected(icon)
                    }
            ) {
                Icon(
                    icon,
                    contentDescription = icon.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = if (isSelected) 3.dp else 0.dp,
                            color = if (isSelected) Green else Color.Transparent,
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
        }
    }
}

val ImageVector.name: String
    get() {
        return this.javaClass.simpleName.removePrefix("Rounded")
    }