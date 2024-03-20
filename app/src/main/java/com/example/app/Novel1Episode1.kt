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
    ContentPause(3),

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
        MakeBottom(categoryWidth, categoryHeight, navController)
        MakeEpisode1Buttons(navController)
        MakeE1PlayButton(player, adsPlayer)
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



@Composable
fun MakeE1PlayButton(player:MediaPlayer?, adsPlayer:MediaPlayer?) {

    val (isPlaying, setIsPlaying) =
        remember {
            mutableIntStateOf(State.Initializing.value)
        }
    val (imageResource, setImageResource) =
        remember { mutableIntStateOf(R.drawable.play_button) }

    Row(
        modifier = Modifier.offset(x = 150.dp, y = 650.dp),
    ) {
        Button(
            modifier = Modifier
                .size(100.dp),
            onClick = {
                // 更改图像资源
                when (isPlaying) {
                    State.Initializing.value -> {
                        //initializing
                        setIsPlaying(State.ADsPlaying.value)
                    }

                    State.ADsPlaying.value -> {
                        adsPlayer!!.start()
                        if (!adsPlayer!!.isPlaying) {
                            setIsPlaying(State.ContentPlaying.value)
                        }

                    }

                    State.ContentPlaying.value -> {
                        adsPlayer!!.seekTo(0)
                        adsPlayer!!.pause()

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
        Button(
            modifier = Modifier
                .offset(x=50.dp, y=20.dp)
                .size(50.dp, 50.dp)
                .alpha(0.3f),
            onClick = {
                if(isPlaying == State.ADsPlaying.value) {
                    setIsPlaying(State.ContentPlaying.value)
                    setImageResource(R.drawable.play_button)
                }
            }
        ) {
            Text("HELLO")
        }

    }
}
