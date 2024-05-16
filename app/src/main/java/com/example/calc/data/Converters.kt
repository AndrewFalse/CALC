package com.example.calc.data

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun toLong(color: Color): Long = color.value.toLong()

    @TypeConverter
    fun toColor(value: Long): Color = Color(value)

    @TypeConverter
    fun getIconName(icon: ImageVector): String {
        return icon.name.split(".")[1]
    }

    @TypeConverter
    fun iconByName(name: String): ImageVector {
        val cl = Class.forName("androidx.compose.material.icons.filled.${name}Kt")
        val method = cl.declaredMethods.first()
        return method.invoke(null, Icons.Filled) as ImageVector
    }
}