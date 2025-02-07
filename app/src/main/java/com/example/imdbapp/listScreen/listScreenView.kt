package com.example.imdbapp.listScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListScreenView() {
    val list = listOf("1", "2", "3")
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        itemsIndexed(list) { index, item ->
            Text(text = item)
        }
    }
}