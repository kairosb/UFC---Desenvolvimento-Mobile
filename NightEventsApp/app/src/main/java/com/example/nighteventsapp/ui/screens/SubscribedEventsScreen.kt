package com.example.nighteventsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nighteventsapp.models.eventList

@Composable
fun SubscribedEventsScreen(navController: NavHostController) {
    val subscribedEvents = eventList.filter { it.isSubscribed.value }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        if (subscribedEvents.isEmpty()) {
            item {
                Text(
                    text = "Você ainda não está inscrito em nenhum evento.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        } else {
            items(count = subscribedEvents.size) { index -> // Corrigido aqui
                val event = subscribedEvents[index] // Acessa o evento pelo índice
                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("eventDetails/${event.id}")
                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = event.imageRes),
                            contentDescription = "Imagem do evento",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(end = 16.dp)
                        )

                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = event.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = event.date,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = event.location,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = event.description,
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 2
                            )
                        }
                    }
                }
            }
        }
    }
}