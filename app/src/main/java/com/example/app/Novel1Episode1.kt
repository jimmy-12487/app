package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun Novel1Episode1(navController: NavHostController) {
    val categoryWidth = 80.dp
    val categoryHeight = 40.dp

    Box(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.novel_1_e1),
            contentDescription = "This is upload page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        MakeBottom(categoryWidth, categoryHeight, navController)
        MakeEpisode1Buttons(navController)
    }
}
@Composable
fun MakeEpisode1Buttons(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .offset(x = (-20).dp, y = 70.dp)
                .align(Alignment.TopEnd)
                .size(40.dp, 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { navController.navigate("novel1Episodes") }
        ) {

        }
    }
}