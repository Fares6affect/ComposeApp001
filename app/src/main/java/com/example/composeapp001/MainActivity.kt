package com.example.composeapp001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp001.ui.theme.ComposeApp001Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeApp001Theme {
                LazyHorizontalStaggeredGrid(
                    rows = StaggeredGridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                        .systemBarsPadding(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalItemSpacing = 8.dp,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(50) {_ ->
                        ItemGrid()
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemGrid(){
    val text = remember {
        mutableStateOf(genText())
    }
    val color = remember {
        mutableStateOf(Color(
            Random.nextInt(255),
            Random.nextInt(255),
            Random.nextInt(255),
            255
        ))
    }
    val width = remember {
        mutableStateOf(Random.nextInt(50, 200).dp)
    }
    Box(Modifier
        .fillMaxHeight()
        .width(width.value)
        .background(color.value)
        .clickable(onClick = { text.value = text.value.dropLast(1) }),
        contentAlignment = Alignment.Center
    ){
        Text(text = text.value,)
    }
}

private fun genText() = Random.nextDouble().toString()