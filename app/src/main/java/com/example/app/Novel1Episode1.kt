package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@Composable
fun Novel1Episode1(navController: NavHostController) {
    Box(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.novel_1_e1),
            contentDescription = "This is upload page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}