package com.example.imdbapp.listScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun ListScreenView() {
    val list = listOf(
        Item(
            "Hellboy: The Crooked Man",
            "https://midias.imagemfilmes.com.br/capas/97d33119-b36d-459f-b042-9a9730ec4fa0_m.jpg?2024-08-09T14:12:15.175350",
            2024,
            1.39,
            "Sobrenatural"
        ),
        Item(
            "Batman",
            "https://files.tecnoblog.net/wp-content/uploads/2022/04/batman.jpg",
            2025,
            1.59,
            "Super Herói"
        ),
        Item(
            "Moana 2",
            "https://lumiere-a.akamaihd.net/v1/images/garland_intl_teaser2_poster_brazil_c487c296.jpeg",
            2025,
            2.03,
            "Infantil"
        ),
        Item(
            "Avatar: The Way of Water",
            "https://static.stealthelook.com.br/wp-content/uploads/2022/09/novos-filmes-que-eu-mal-posso-esperar-para-ver-esse-ano-avatar-the-way-of-the-water-20220908180112.jpg",
            2025,
            2.27,
            "Fantasia"
        ),
        Item(
            "Avatar: The Way of Water",
            "https://www.cafecomfilme.com.br/media/k2/items/cache/fe8bfc1b99c9ede76699e9aaec65452f_XL.jpg?t=20190718_161320",
            2025,
            1.43,
            "Super Herói"
        )
    )

    val groupedByGender = list.groupBy { it.gender }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Define o fundo preto aqui
            .padding(top = 50.dp, bottom = 50.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            groupedByGender.forEach { (gender, items) ->
                item {
                    Text(
                        text = gender,
                        style = genderStyle,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    LazyRow(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        itemsIndexed(items) { _, item ->
                            MoveItem(
                                item.img,
                                item.title,
                                item.year,
                                item.duration
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MoveItem(
    img: String,
    title: String,
    year: Int,
    duration: Double,
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .padding(end = 15.dp)
    ) {
        AsyncImage(
            model = img,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                style = fontStyle,
                text = year.toString()
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                style = fontStyle,
                text = "${duration}h"
            )
        }
    }
}

val genderStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 30.sp,
    color = Color.White
)

val fontStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    color = Color.White
)

data class Item(
    val title: String,
    val img: String,
    val year: Int,
    val duration: Double,
    val gender: String
)