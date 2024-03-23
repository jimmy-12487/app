package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MakeNovel1Episodes(navController: NavHostController) {
    Box(
        modifier = Modifier
    ) {
        val categoryWidth = 80.dp
        val categoryHeight = 40.dp
        Image(
            painter = painterResource(id = R.drawable.novel_1_episodes),
            contentDescription = "This is upload page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(){
            Button(
                onClick = { navController.navigate("novel1Episode1")},
                modifier = Modifier
                    .size(width = 400.dp, height = 45.dp)
                    .offset(x = 0.dp, y = 385.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ){}
        }
        MakeEpisodesButtons(navController)
        MakeBottom(categoryWidth, categoryHeight, navController)

    }
}
@Composable
fun MakeEpisodesButtons(navController: NavHostController){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(60.dp, 60.dp)
                .offset((-14).dp, 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { navController.navigate("mainPage") }
        ) {

        }
    }
}
