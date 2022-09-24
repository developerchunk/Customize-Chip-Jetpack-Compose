package com.example.customchipgroup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChipGroupCompose() {
    
    val chipList: List<String> = listOf(
        "Spent",
        "Add Funds",
        "Savings"
    )

    var selected by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(start = 30.dp,top = 50.dp)
            .fillMaxWidth()
    ) {
        chipList.forEach { it ->
            Chip(
                title = it,
                selected = selected,
                onSelected = {
                    selected = it
                }
            )
        }
    }

}

@Composable
fun Chip(
    title: String,
    selected: String,
    onSelected: (String) -> Unit
) {

    val isSelected = selected == title

    val background = if (isSelected) Color.Blue else Color.LightGray
    val contentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .padding(end = 10.dp)
            .height(35.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = {
                    onSelected(title)
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            AnimatedVisibility(visible = isSelected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "check",
                    tint = Color.White
                )
            }

            Text(text = title, color = contentColor, fontSize = 16.sp)

        }
    }

}










