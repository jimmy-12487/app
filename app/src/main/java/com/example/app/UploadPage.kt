package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun UploadPage(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val categoryWidth = 80.dp
        val categoryHeight = 40.dp
        Image(
            painter = painterResource(id = R.drawable.upload_page),
            contentDescription = "This is upload page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        MakeBottom(categoryWidth, categoryHeight, navController)
    }
}