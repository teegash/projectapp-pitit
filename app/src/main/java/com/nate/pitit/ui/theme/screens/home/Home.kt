package com.nate.pitit.ui.theme.screens.home

import android.content.Context
import android.net.Uri
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.nate.pitit.navigation.ROUTE_EXPENSES
import com.nikolovlazar.goodbyemoney.R

private fun Context.buildExoPlayer(uri: Uri)=
    ExoPlayer.Builder(this).build().apply {
        setMediaItem(MediaItem.fromUri(uri))
        repeatMode = Player.REPEAT_MODE_ALL
        playWhenReady = true
        prepare()
    }

private fun Context.buildPlayerView(exoPlayer: ExoPlayer) =
    StyledPlayerView(this).apply {
        player = exoPlayer
        layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        useController = false
        resizeMode = RESIZE_MODE_ZOOM
    }


@Composable
fun Home(navController: NavHostController, videoUri: Uri) {

    val context = LocalContext.current
    val exoPlayer = remember { context.buildExoPlayer(videoUri)}

    DisposableEffect(AndroidView(factory = { it.buildPlayerView(exoPlayer) },
        modifier = Modifier.fillMaxSize()
    )){
        onDispose {
            exoPlayer.release()
        }
    }
    
    Column (
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = R.drawable.cashlogo), contentDescription = null, Modifier.size(80.dp),
            tint = Color.White)

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { navController.navigate(ROUTE_EXPENSES) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "ENTER  PITIT", fontSize = 20.sp)
        }
        
        
        
    }

}



//@Preview
//@Composable
//fun prev() {
//
//    Home(rememberNavController(), videoUri = Uri)
//
//}