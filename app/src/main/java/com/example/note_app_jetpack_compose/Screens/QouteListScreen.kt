package com.example.note_app_jetpack_compose.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.note_app_jetpack_compose.Model.Qoute
import com.example.note_app_jetpack_compose.R

@Composable
fun QouteListScreen(data:Array<Qoute>,onClick:(quote:Qoute)->Unit) {
    Column() {

        Text(text = "Quote App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp,24.dp).fillMaxWidth(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = FontFamily(Font(R.font.sunday))

        )
        QouteList(data = data ,onClick)
    }
}