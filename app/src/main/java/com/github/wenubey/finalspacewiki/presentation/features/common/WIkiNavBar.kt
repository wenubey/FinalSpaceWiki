package com.github.wenubey.finalspacewiki.presentation.features.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor

@Composable
fun WikiNavBar(
  navController: NavController
) {

  val items = listOf(
    WikiNavBarItem.CharacterList,
    WikiNavBarItem.LocationList
  )
  BottomNavigation(
    modifier = Modifier
      .fillMaxWidth(),
    backgroundColor = appBarColor,
    contentColor = Color.White
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
      BottomNavigationItem(
        alwaysShowLabel = true,
        selected = currentRoute == item.route,
        onClick = {
          navController.navigate(item.route) {
            navController.graph.startDestinationRoute?.let { route ->
              popUpTo(route) {
                saveState = true
              }
            }
            launchSingleTop = true
            restoreState = true
          }
        },
        icon = {
          Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            )
        },
        label = { Text(text = item.title, style = MaterialTheme.typography.body1) },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
      )
    }
  }
}
