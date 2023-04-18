@file:OptIn(DelicateCoroutinesApi::class)

package com.github.wenubey.finalspacewiki.presentation.features.location.location_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.wenubey.finalspacewiki.presentation.features.common.WikiTopBar
import com.github.wenubey.finalspacewiki.presentation.features.location.LocationViewModel
import com.github.wenubey.finalspacewiki.presentation.ui.theme.backGroundColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterialScaffoldPaddingParameter")
fun LocationDetailScreen(
    viewModel: LocationViewModel = hiltViewModel(),
    id: Int? = 0,
    navController: NavController
) {
    GlobalScope.launch {
        viewModel.loadLocation(id!!)
    }
    val openDialog = remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = backGroundColor,
        topBar = {
            WikiTopBar(openDialog = openDialog)
        },
        content = {
            viewModel.locationDataState.data?.let { data ->
                LocationDetailCard(
                    data = data,
                    navController = navController,
                    locationViewModel = viewModel
                )
            }
        }
    )
}