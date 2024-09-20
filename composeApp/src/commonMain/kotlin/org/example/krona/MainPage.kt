package org.example.krona

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape

data class Event(val title: String, val time: String, val room: String)

val schedule = listOf(
    Event("Обучение", "12:00-13:30", "1 ауд."),
    Event("Индивидуальное собрание", "14:00-15:00", "1 ауд."),
    Event("Круглый стол", "12:00-13:30", "2 ауд.")
)

@Composable
fun MainPage() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F1F1))
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    NowSection()
                }
                item {
                    ScheduleSection()
                }
                items(schedule) { event ->
                    ScheduleItem(event, isFirst = schedule.first() == event, isLast = schedule.last() == event)
                }
            }
        }
    }
}

@Composable
fun NowSection() {
    Text(
        text = "Сейчас",
        fontSize = 20.sp,
        color = Color(0xFF0F1C2E),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFF0F1C2E)
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Обучение",
                color = Color(0xFF00FF92),
                fontSize = 16.sp
            )
            Text(
                text = "12:00-13:30",
                color = Color(0xFF8F8F8F),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ScheduleSection() {
    Text(
        text = "ЧЕТВЕРГ, 19 СЕНТЯБРЯ",
        fontSize = 14.sp,
        color = Color(0xFF8F8F8F),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
fun ScheduleItem(event: Event, isFirst: Boolean, isLast: Boolean) {
    // Округление верхней и нижней части списка
    val shape: Shape = when {
        isFirst && isLast -> RoundedCornerShape(16.dp)
        isFirst -> RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        isLast -> RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
        else -> RectangleShape
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(shape),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color(0xFF0F1C2E)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = event.title,
                        color = Color(0xFFFFE7D3),
                        fontSize = 16.sp
                    )
                    Text(
                        text = event.room,
                        color = Color(0xFF8F8F8F),
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = event.time,
                    color = Color(0xFF8F8F8F),
                    fontSize = 16.sp
                )
            }
        }

        // Бежевая полоска между карточками
        if (!isLast) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xFFFFE7D3))
            )
        }
    }
}