package com.example.app

import android.media.MediaPlayer
import android.widget.ImageView
import android.widget.Button
import androidx.activity.ComponentActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

enum class State(val value: Int) {
    Initializing (0),
    ADsPlaying (1),
    ContentPlaying(2),
    ContentPause(3)
}
@Composable
fun Novel1Episode1(player: MediaPlayer?, adsPlayer: MediaPlayer?, navController: NavHostController) {
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
    }
    MakeE1PlayButton(player, adsPlayer, navController)
}

@Composable
fun MakeE1PlayButton(player:MediaPlayer?, adsPlayer:MediaPlayer?, navController: NavHostController) {
    val (isPlaying, setIsPlaying) =
        remember {
            mutableIntStateOf(State.Initializing.value)
        }
    val (imageResource, setImageResource) =
        remember { mutableIntStateOf(R.drawable.play_button) }
    val categoryWidth = 80.dp
    val categoryHeight = 40.dp
    when (isPlaying){
        State.Initializing.value -> {
            //initializing
            setIsPlaying(State.ADsPlaying.value)
        }
    }
    Row(
        modifier = Modifier.offset(x = 153.dp, y = 638.dp),
    ) {
        Button(
            modifier = Modifier
                .size(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {
                // 更改圖片
                when (isPlaying) {
                    State.ADsPlaying.value -> {
                        adsPlayer!!.start()
                        setImageResource(R.drawable.pause_button)
                        if (!adsPlayer!!.isPlaying) {
                            setIsPlaying(State.ContentPlaying.value)
                        }
                    }
                    State.ContentPlaying.value -> {
                        adsPlayer!!.seekTo(0)
                        //adsPlayer!!.reset()
                        setImageResource(R.drawable.pause_button)
                        player!!.start()
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
        Button(
            modifier = Modifier
                .offset(x=50.dp, y=20.dp)
                .size(50.dp, 50.dp)
                .alpha(0.3f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {
                if(isPlaying == State.ADsPlaying.value) {
                    adsPlayer!!.pause()
                    setIsPlaying(State.ContentPlaying.value)
                    setImageResource(R.drawable.play_button)
                }
            }
        ) {}
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier
                .offset(x = (-20).dp, y = 70.dp)
                .align(Alignment.TopEnd)
                .size(40.dp, 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { navController.navigate("novel1Episodes")}
        ) {

        }
    }
    Row(
        modifier = Modifier
            .offset(x = 0.dp, y = 791.dp)
            .alpha(0f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            onClick = {navController.navigate("mainPage")},
            modifier = Modifier
                .offset(x = 5.dp, y = 0.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 0.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
        }
        Button(
            onClick = {},
            modifier = Modifier
                .offset(x = 5.dp, y = 0.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
        }
        Button(
            onClick = { navController.navigate("uploadPage")},
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .padding(horizontal = 8.dp)
                .size(width = categoryWidth, height = categoryHeight)
        ) {
        }
    }
}
