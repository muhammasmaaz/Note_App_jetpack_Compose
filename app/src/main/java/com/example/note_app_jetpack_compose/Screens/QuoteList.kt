package com.example.note_app_jetpack_compose.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.note_app_jetpack_compose.Model.Qoute

@Composable
fun QouteList(data:Array<Qoute>,onClick:(quote:Qoute)->Unit) {
    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it,onClick)
        }
    })
    
}