package org.example.krona

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import krona.composeapp.generated.resources.Res
import krona.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.DrawableResource

data class Event(val title: String, val time: String, val room: String, val event_manager: String)

val schedule = listOf(
    Event("Обучение", "12:00-13:30", "Общий зал", "Газпром"),
    Event("Индивидуальное собрание", "14:00-15:00", "1 переговорная", "инд."),
    Event("Круглый стол", "17:00-18:30", "3 этаж, 2 каб.", "Янис Кайшев"),
)

@Composable
fun MainPage() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F1F1))
                .padding(horizontal = 20.dp, vertical = 45.dp)
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
                itemsIndexed(schedule) { index, event ->
                    ScheduleItem(event, isFirst = index == 0, isLast = index == schedule.lastIndex)
                }
            }
        }
    }
}

@Composable
fun NowSection() {
    Text(
        text = "Сейчас",
        fontFamily = raleway,
        fontSize = 20.sp,
        fontWeight = FontWeight.W600,
        color = Color(0xFF0F1C2E),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(105.dp)
            .clip(RoundedCornerShape(25.dp)),
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
                fontFamily = raleway,
                fontWeight = FontWeight.W600,
                color = Color(0xFFFFE7D3),
                fontSize = 15.sp
            )
            Text(
                text = "12:00-13:30",
                fontWeight = FontWeight.W600,
                color = Color(0xFF8F8F8F),
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun ScheduleSection() {
    Row {
        Text(
            text = "Расписание",
            fontFamily = raleway,
            fontSize = 20.sp,
            fontWeight = FontWeight.W600,
            color = Color(0xFF0F1C2E),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, bottom = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.Arrow),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)),
        shape = RectangleShape,
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
                text = "ПЯТНИЦА, 20 СЕНТЯБРЯ",
                fontSize = 15.sp,
                fontWeight = FontWeight.W600,
                color = Color(0xFFFFE7D3),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color(0xFF6F635A))
    )
}

@Composable
fun ScheduleItem(event: Event, isFirst: Boolean, isLast: Boolean) {
    val shape: Shape = when {
        isLast -> RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
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
                .height(105.dp)
                .clip(shape),
            shape = shape,
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color(0xFF0F1C2E)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, end = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column (
                ){
                    Spacer(modifier = Modifier.height(4.dp))
                Card(
                    modifier = Modifier
                        .height(15.dp)
                        .width(20.dp)
                        .clip(RoundedCornerShape(topEnd = 25.dp, bottomEnd = 25.dp)),
                    shape = RectangleShape,
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = Color(0xFFFFE7D3)
                    ),
                ) {}}
                Spacer(modifier = Modifier.width(7.dp))
                Column (
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                ){

                    Text(
                        text = event.title,
                        fontFamily = raleway,
                        fontWeight = FontWeight.W600,
                        color = Color(0xFFFFE7D3),
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = event.room,
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF8F8F8F),
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = event.event_manager,
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF8F8F8F),
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = event.time,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF8F8F8F),
                    fontSize = 15.sp
                )
            }
        }

        if (!isLast) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xFF6F635A))
            )
        }
    }
}