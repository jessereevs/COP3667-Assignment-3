package com.example.artspcaeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspcaeapp.ui.theme.ArtSpcaeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpcaeAppTheme {
                    ArtSpaceApp()
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    ArtSpaceWithImageDescriptionAndButtons(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun ArtSpaceWithImageDescriptionAndButtons(modifier: Modifier = Modifier) {
    var currentImage by remember { mutableStateOf(1) }

    val imageResource = when (currentImage) {
        1 -> R.drawable.americanflag
        2 -> R.drawable.bootprint
        3 -> R.drawable.earthbehindmoon
        4 -> R.drawable.earthoverview
        5 -> R.drawable.mooncraters
        else -> R.drawable.shuttleshadow
    }

    val descriptionResource = when (currentImage) {
        1 -> "American flag on the moon."
        2 -> "Boot print on the surface of the moon."
        3 -> "Earth seen from the surface of the moon."
        4 -> "Earth from the space shuttle."
        5 -> "Craters on the moon."
        else -> "Shadow of the shuttle."
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(30.dp).border(
                width = 2.dp, // Thickness of the border
                color = Color.Black, // Color of the border
            ),
            painter = painterResource(imageResource),
            contentDescription = "1"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(descriptionResource)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Project Apollo Archive - 2015",
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(
                onClick = { if (currentImage > 1) currentImage -= 1 },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "Previous Image")
            }
            Button(
                onClick = { if (currentImage < 6) currentImage += 1 },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Next Image")
            }
        }
    }
}