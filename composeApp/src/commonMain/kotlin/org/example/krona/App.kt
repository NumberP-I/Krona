@file:OptIn(ExperimentalMaterial3Api::class)

package org.example.krona

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import krona.composeapp.generated.resources.Res
import krona.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf("MainPage") }
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFF0F1C2E),
                        titleContentColor = Color(0xFFFFE7D3),
                    ),
                    title = {
                        Text(
                            "Главная",
                            maxLines = 1,
                            color = Color(0xFFFFE7D3),
                        )
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color(0xFF0F1C2E),
                    contentColor = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                ) {
                    val items = listOf(
                        BottomNavItem("Главная", Res.drawable.MainPage),
                        BottomNavItem("Календарь", Res.drawable.Calendar),
                        BottomNavItem("Мероприятия", Res.drawable.Events),
                        BottomNavItem("Аккаунт", Res.drawable.PersonalAccount)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        items.forEachIndexed { index, item ->
                            BottomNavigationItem(
                                modifier = Modifier
                                    .size(65.dp),
                                icon = {
                                    Icon(
                                        painterResource(item.iconRes),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp),
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.label,
                                        color = Color(0xFFFFE7D3).copy(alpha = 0.3f),
                                        fontSize = 10.sp,
                                    )
                                },
                                selected = currentScreen == getScreenForIndex(index),
                                onClick = {
                                    currentScreen = getScreenForIndex(index)
                                },
                                selectedContentColor = Color(0xFFFFE7D3),
                                unselectedContentColor = Color.White
                            )
                        }
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
                        Krona()
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
        else -> "Krona"
    }
}

data class BottomNavItem(val label: String, val iconRes: DrawableResource)