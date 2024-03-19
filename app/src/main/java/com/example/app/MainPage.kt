package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun MainPage(navController: NavHostController) {
    val categoryWidth = 80.dp
    val categoryHeight = 40.dp
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.homepage),
            contentDescription = "This is main page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column (
            modifier = Modifier
                .offset(x = 0.dp, y = 340.dp)
        )
        {
            MakeFirstRow(categoryWidth, categoryHeight, navController)
            MakeSecondRow(categoryWidth, categoryHeight, navController)
            MakeUploadRow(categoryWidth, categoryHeight, navController)
            MakePopNovelRow(categoryWidth, categoryHeight, navController)


        }
    }
}

@Composable
fun MakeFirstRow(categoryWidth: Dp, categoryHeight: Dp, navController: NavHostController) {
    Row(
        modifier = Modifier
            .alpha(0f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "男生")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "女生")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "玄幻")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "言情")
        }
    }
}

@Composable
fun MakeSecondRow(categoryWidth: Dp, categoryHeight: Dp, navController: NavHostController) {
    Row(
        modifier = Modifier
            .offset(x = 0.dp, y = 10.dp)
            .alpha(0f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "末日")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "重生")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "浪漫")
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 20.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
            Text(text = "寫實")
        }
    }
}

@Composable
fun MakeUploadRow(categoryWidth: Dp, categoryHeight: Dp, navController: NavHostController) {
    Row(
        modifier = Modifier.offset(x = 0.dp, y = 0.dp)
    ) {
        Button(
            onClick = { navController.navigate("uploadPage") },
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .offset(x = 70.dp, y = 15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Image(painter = painterResource(id = R.drawable.upload_icon), contentDescription = null)
        }
    }
}

@Composable
fun MakePopNovelRow(categoryWidth: Dp, categoryHeight: Dp, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = 0.dp, y = 0.dp)
    ) {
        Button(
            onClick = { navController.navigate("novel1Episodes") },
            modifier = Modifier,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.novel_1),
                contentDescription = "first novel"
            )
        }
        Button( onClick = { /*TODO*/ },
            modifier = Modifier,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.novel_2),
                contentDescription = "first novel"
            )
        }
    }
}