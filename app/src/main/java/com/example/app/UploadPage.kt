package com.example.app

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun UploadPage(player: MediaPlayer?, navController: NavHostController) {
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
        MakeUpPlayButton(player)
    }
}
@Composable
fun MakeUpPlayButton(player: MediaPlayer?) {
    val (isPlaying, setIsPlaying) =
        remember {
            mutableIntStateOf(State.Initializing.value)
        }
    val (imageResource, setImageResource) =
        remember { mutableIntStateOf(R.drawable.play_button) }

    Row(
        modifier = Modifier.offset(x = 150.dp, y = 580.dp),
    ) {
        Button(
            modifier = Modifier
                .size(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {
                // 更改图像资源
                when (isPlaying) {
                    State.Initializing.value -> {
                        //initializing
                        setIsPlaying(State.ContentPlaying.value)
                    }
                    State.ContentPlaying.value -> {
                        player!!.start()
                        setImageResource(R.drawable.pause_button)
                        setIsPlaying(State.ContentPause.value)

                    }
                    State.ContentPause.value -> {
                        player!!.pause()
                        setImageResource(R.drawable.play_button)
                        setIsPlaying(State.ContentPlaying.value)
                    }
                }
            }) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
            )
        }

    }
}