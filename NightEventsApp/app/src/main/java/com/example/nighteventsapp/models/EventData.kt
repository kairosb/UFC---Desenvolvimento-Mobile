package com.example.nighteventsapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)


val eventList = listOf(
    Event(
        id = 1,
        title = "Campeonato Mundial de E-Sports 2024",
        description = "Os melhores times competindo em diversos jogos de e-sports.",
        date = "2024-09-10",
        location = "Arena Gamer Global",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img1
    ),
    Event(
        id = 2,
        title = "Festival Indie Games",
        description = "Celebração dos jogos independentes com lançamentos e demos.",
        date = "2024-10-05",
        location = "Centro Cultural Indie",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img2
    ),
    Event(
        id = 3,
        title = "Game Dev Conference 2024",
        description = "Palestras e workshops sobre desenvolvimento de jogos.",
        date = "2024-11-20",
        location = "Universidade de Tecnologia",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img3
    ),
    Event(
        id = 4,
        title = "Lançamento de Console XYZ",
        description = "Apresentação e testes do novo console revolucionário XYZ.",
        date = "2024-08-25",
        location = "Espaço Gamer Tech",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img5
    ),
    Event(
        id = 5,
        title = "Retro Gaming Expo",
        description = "Exposição de consoles e jogos clássicos dos anos 80 e 90.",
        date = "2024-09-30",
        location = "Centro Histórico de Jogos",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img4
    ),
    Event(
        id = 6,
        title = "Campeonato Battle Royale 2024",
        description = "Competição intensa no gênero Battle Royale com prêmios incríveis.",
        date = "2024-11-15",
        location = "Arena BR Extreme",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img2
    ),
    Event(
        id = 7,
        title = "VR Gaming Experience",
        description = "Experimente os melhores jogos de realidade virtual do momento.",
        date = "2024-12-10",
        location = "VR Tech Space",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img3
    )
)

