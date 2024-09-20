package org.example.krona

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import krona.composeapp.generated.resources.Res
import krona.composeapp.generated.resources.code_one
import krona.composeapp.generated.resources.code_two
import krona.composeapp.generated.resources.code_three
import org.jetbrains.compose.resources.DrawableResource

import krona.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf("main") }

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ) {
                    val items = listOf(
                        BottomNavItem("Главная", Res.drawable.MainPage),
                        BottomNavItem("Календарь", Res.drawable.Calendar),
                        BottomNavItem("Мероприятия", Res.drawable.Events),
                        BottomNavItem("Личный кабинет", Res.drawable.PersonalAccount)
                    )

                    items.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = { Icon(painterResource(item.iconRes), contentDescription = null) },
                            label = { Text(item.label) },
                            selected = currentScreen == getScreenForIndex(index),
                            onClick = {
                                currentScreen = getScreenForIndex(index)
                            },
                            selectedContentColor = Color.Blue,
                            unselectedContentColor = Color.Gray
                        )
                    }
                }
            }
        ) { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (currentScreen) {
                    "MainPage" -> {
                        MainPage()
                    }
                    "Calendar" -> {
                        Calendar()
                    }
                    "Events" -> {
                        Events()
                    }
                    "PersonalAccount" -> {
                        PersonalAccount()
                    }
                    else -> {
                        Text("main", Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

fun getScreenForIndex(index: Int): String {
    return when (index) {
        0 -> "MainPage"
        1 -> "Calendar"
        2 -> "Events"
        3 -> "PersonalAccount"
        else -> "main"
    }
}

data class BottomNavItem(val label: String, val iconRes: DrawableResource)