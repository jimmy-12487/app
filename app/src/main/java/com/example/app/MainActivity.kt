package com.example.app

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.theme.APPTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val adsPlayer = MediaPlayer.create(this, R.raw.ads)
            val player = MediaPlayer.create(this, R.raw.novel)
            val navController = rememberNavController()
            APPTheme {
                NavHost(navController, startDestination = "mainPage") {
                    composable("mainPage") {
                        MainPage(navController)
                    }
                    composable("uploadPage") {
                        UploadPage(player, navController)
                    }
                    composable("novel1Episodes") {
                        MakeNovel1Episodes(navController)
                    }
                    composable("novel1Episode1") {
                        Novel1Episode1(player, adsPlayer, navController)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    val mediaPlayer: MediaPlayer? = null

    APPTheme {
        NavHost(navController, startDestination = "novel1Episode1") {
            composable("mainPage") {
                MainPage(navController)
            }
            composable("uploadPage") {
                UploadPage(mediaPlayer, navController)
            }
            composable("novel1Episodes") {
                MakeNovel1Episodes(navController)
            }
            composable("novel1Episode1") {
                Novel1Episode1(mediaPlayer, mediaPlayer, navController)
            }

        }
    }
}
