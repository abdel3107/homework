package com.example.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtApp(
    modifier: Modifier = Modifier
){
    var currentArtIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = appBar()

    ) {
            innerPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = artworks[currentArtIndex].imageRes),
                contentDescription = artworks[currentArtIndex].title,
                modifier = Modifier
                    .height(600.dp)
                    .width(500.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = artworks[currentArtIndex].title, fontSize = 30.sp)
            Text(text = artworks[currentArtIndex].artist, fontSize = 20.sp)
            Text(text = artworks[currentArtIndex].year, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { currentArtIndex = (currentArtIndex - 1 + artworks.size) % artworks.size },
                enabled = currentArtIndex > 0,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {currentArtIndex = (currentArtIndex + 1) % artworks.size },
                enabled = currentArtIndex + 1 < artworks.size ,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "next")
            }
        }

        }
    }
}



