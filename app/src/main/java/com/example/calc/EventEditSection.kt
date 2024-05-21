package com.example.calc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.ui.theme.Blue
import com.example.calc.ui.theme.Green
import com.example.calc.ui.theme.Orange


@Composable
fun EventEditSection() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
            )
    {
        Button(modifier = Modifier
            .height(120.dp)
            .width(400.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Добавить",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(modifier = Modifier
            .height(120.dp)
            .width(400.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Обновить",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(modifier = Modifier
            .height(120.dp)
            .width(400.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Удалить",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}