package com.github.wenubey.finalspacewiki.presentation.features.common


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.wenubey.finalspacewiki.presentation.ui.theme.appBarColor
import com.github.wenubey.finalspacewiki.presentation.util.Size

@Composable
fun WikiNavBar(
  navController: NavController,
) {

  val items = listOf(
    WikiNavBarItem.CharacterList,
    WikiNavBarItem.LocationList,
    WikiNavBarItem.EpisodeList,
  )
  val screenSize = Size()
  val screenHeight = screenSize.height()
  val screenWidth = screenSize.width()
  BottomNavigation(
    modifier = Modifier
      .fillMaxWidth()
      .size(
        width = screenWidth.dp,
        height = (screenHeight * 0.07).dp,
      )
      .clip(AbsoluteRoundedCornerShape(topLeft = 16.dp, topRight = 16.dp)),
    backgroundColor = appBarColor,
    contentColor = Color.White,
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
