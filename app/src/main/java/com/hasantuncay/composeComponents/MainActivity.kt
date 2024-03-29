package com.hasantuncay.composeComponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.hasantuncay.composeComponents.components.AnimatedCounter

import com.hasantuncay.composeComponents.ui.theme.PractiseTheme

class MainActivity : ComponentActivity() {
    val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          
            val navController= rememberNavController()

            PractiseTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


NavigationController(   viewModel)

                }
            }
        }
    }
}
@Composable
fun SmallExample(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting( ) {
    var number by remember {
        mutableStateOf(0)
    }
    var progress by remember {
        mutableStateOf(0f)
    }
    val animatedNumber by animateIntAsState(
        targetValue = number,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = ""
    )
    val max= 100
    LaunchedEffect(key1 = number, block ={
        LinearProgressIndicatorCalculate(prgress = number, max =max ){
            progress=it
            Log.d("progress", "Greeting: $progress")
        }
    } )
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        LinearProgressBar(progress = number, max = max)

        LinearProgressIndicator(progress = progress, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp))
        AnimatedNumberDisplay(animatedNumber = animatedNumber)
        AnimatedCounter(count = number,
            style = TextStyle(fontSize = 46.sp)
        )

        Row (Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { number++ }) {
             Text(text = "Increase")

            }
            Button(onClick = { number-- }) {
                Text(text = "Decrease")

            }
        }

    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNumberDisplay(animatedNumber: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Value: ", fontSize = 46.sp)
        // AnimatedContent yalnızca sayısal değer için kullanılır

        AnimatedContent(
            targetState = animatedNumber,
            transitionSpec = {
                fadeIn(animationSpec = tween(1000, delayMillis = 90)) +
                        scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)) with
                        fadeOut(animationSpec = tween(1000))
            }, label = ""
        ) { targetNumber ->
            Text(
                text = targetNumber.toString(),
                fontSize = 46.sp
            )
        }
    }
}

@Composable
fun LinearProgressBar(
    progress: Int,
    max: Int,
    modifier: Modifier = Modifier
) {
    // Eğer progress 0 ise, en az 1'e çek
    val displayProgress = progress+1

    val animatedProgress = animateFloatAsState(
        targetValue = (displayProgress.toFloat() / max) * 100f,
        animationSpec = tween(1000), label = ""
    ).value
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.White, Color.Red)
    )
    Box(
        modifier = modifier
            .clip(CircleShape)
            .height(10.dp)
            .fillMaxWidth()
            .background(Color.White)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(animatedProgress / 100f)
                .fillMaxHeight()
                .background(brush = gradientBrush)
                .clip(CircleShape)
        ) {}
    }


}

fun LinearProgressIndicatorCalculate(prgress: Int, max : Int,updateProgress:(Float)-> Unit){

updateProgress((prgress.toFloat()/max.toFloat()) )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //ButtonScreen( )
}







