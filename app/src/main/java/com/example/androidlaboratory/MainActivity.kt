package com.example.androidlaboratory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.androidlaboratory.ui.theme.AndroidLaboratoryTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val skmodern = FontFamily(
    Font(R.font.skmodernistregular, FontWeight.Normal)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AndroidLaboratoryTheme {
                // A surface container using the 'background' color from the theme
                ApplySystemBarColors()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent,
                ){
                    DotaScreen()
                }
            }
        }
    }
}
@Composable
private fun DotaHeader(){
        Image(
            painter = painterResource(id = R.drawable.headerimage),
            contentDescription = "Header",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
}

@Composable
private fun DotaLogo(){
    Row(
        Modifier
            .fillMaxWidth()
         //   .height(80.dp)
    )
    {
        Box(
            modifier = Modifier
                .offset(20.dp, -40.dp)
                .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .size(100.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                painter = painterResource(id = R.drawable.dota),
                contentDescription = "Dota",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
            )
        }
        Column(
            Modifier.offset(40.dp)
        ) {
            Text(
                text = "DoTA 2",
                fontSize = 24.sp,
                color = Color(0xFFFFFFFF),
                fontFamily = skmodern,
                fontWeight = FontWeight.Normal,
            )
            Row() {
                for (i in 0..4) {
                    Icon(
                        Icons.Filled.Star, "bsw", tint = Color.Yellow, modifier = Modifier
                            .size(15.dp)
                            .offset((3 * i).dp)
                    )

                }
                Text(
                    text = "70M", Modifier.offset(15.dp), fontSize = 12.sp,
                    color = Color(0xFF45454D),
                    fontFamily = skmodern,
                    fontWeight = FontWeight.Normal,
                )
            }

        }
    }
}

@Composable
private fun DotaTags(){
    LazyRow(
        modifier = Modifier
            .offset(24.dp, 0.dp)
            .height(50.dp)
    ) {
        val list = listOf("MOBA", "MULTIPLAYER", "STRATEGY")
        itemsIndexed(list)
        { _, item ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0x3D44A9F4))
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(vertical = 5.dp),
                    fontSize = 14.sp,
                    fontFamily = skmodern,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF41A0E7)
                )
            }
        }
    }
}

@Composable
private fun DotaDesc(){
    Text(
        text = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a" +
                " large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
        fontSize = 12.sp,
        modifier = Modifier
            .offset(24.dp, 0.dp)
            .width(350.dp)
            .height(120.dp),
        fontFamily = skmodern,
        fontWeight = FontWeight.Normal,
        color = Color(0xB3EEF2FB)
    )
}

@Composable
private fun DotaImages(){
    LazyRow(
        modifier = Modifier
            // .offset(0.dp, 50.dp)
            .fillMaxWidth()
            .height(128.dp)
    )
    {
        item {
            Image(
                painter = painterResource(id = R.drawable.first),
                contentDescription = "FirstImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(240.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.second),
                contentDescription = "SecondImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(240.dp)
                    .offset(10.dp, 0.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
private fun DotaRating(){
    Column(
        Modifier
            .offset(24.dp, 10.dp)
            .fillMaxWidth()
    )
    {
        Text(
            text = "Review & Ratings",
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            fontFamily = skmodern,
            fontWeight = FontWeight.Normal
        )
        Row(
            modifier = Modifier
                .offset(0.dp, 10.dp)
        )
        {
            Text(text = "4.9", fontSize = 40.sp,
                color = Color(0xFFFFFFFF),
                fontFamily = skmodern,
                fontWeight = FontWeight.Normal)
            for (i in 0..3) {
                Icon(
                    Icons.Filled.Star, "bsw", tint = Color.Yellow, modifier = Modifier
                        .size(15.dp)
                        .offset(20.dp, 5.dp)
                )
            }
            Icon(
                Icons.Filled.StarHalf, "wrb", tint = Color.Yellow, modifier = Modifier
                    .size(15.dp)
                    .offset(20.dp, 5.dp)
            )
            Text(
                text = "70M Reviews",
                modifier = Modifier.offset(-60.dp, 20.dp),
                color = Color(0xFFA8ADB7),
                fontSize = 14.sp,
                fontFamily = skmodern,
                fontWeight = FontWeight.Normal
            )
        }

    }
}

@Composable
private fun DotaReview(){
    LazyColumn(
        Modifier
           // .offset(24.dp, 0.dp)
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .height(500.dp)
    )
    {
        item {
            Box(
                Modifier
                    // .offset(24.dp, 80.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                //.background(color = Color.Green)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .offset(10.dp, 50.dp)
                )
                Text(
                    text = "Auguste Conte",
                    fontSize = 20.sp,
                    modifier = Modifier.offset(70.dp, 50.dp),
                    color = Color(0xFFFFFFFF),
                    fontFamily = skmodern,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "February 14, 2019",
                    fontSize = 12.sp,
                    modifier = Modifier.offset(70.dp, 85.dp),
                    fontFamily = skmodern,
                    color = Color(0x66FFFFFF)
                )
                Text(
                    text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .offset(10.dp, 120.dp)
                        .width(300.dp),
                    fontFamily = skmodern,
                    color = Color(0xB3EEF2FB)
                )
            }
        }
        item {
            Box()
            {
                Divider(
                    color = Color(0xFF1a1f29),
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 25.dp, start = 20.dp, end = 20.dp)
                )
            }
        }
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.avatar2),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .offset(10.dp, 50.dp)
                )
                Text(
                    text = "Jang Marcelino",
                    fontSize = 20.sp,
                    modifier = Modifier.offset(70.dp, 50.dp),
                    color = Color(0xFFFFFFFF),
                    fontFamily = skmodern
                )
                Text(
                    text = "February 14, 2019",
                    fontSize = 12.sp,
                    modifier = Modifier.offset(70.dp, 85.dp),
                    fontFamily = skmodern,
                    color = Color(0x66FFFFFF)
                )
                Text(
                    text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .offset(10.dp, 120.dp)
                        .width(300.dp),
                    fontFamily = skmodern,
                    color = Color(0xB3EEF2FB)
                )
            }
        }
    }
}

@Composable
private fun InstallButton(){
    Box(modifier = Modifier.height(150.dp))
    {
        Button(
            onClick = {      },
            modifier = Modifier
                //   .padding(8.dp)
                // .offset(0.dp, 100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .width(500.dp),

            colors = ButtonDefaults.buttonColors(Color(0xFFF4D144))
        ) {
            Text(text = "Install",
                fontSize = 24.sp,
                color = Color.Black,
                fontFamily = skmodern,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun DotaScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF050B18)),
    ) {
        item {
            DotaHeader()
        }
        item {
            DotaLogo()
        }
        item{
            DotaTags()
        }
        item {
            DotaDesc()
        }
        item {
            DotaImages()
        }
        item {
            DotaRating()
        }
        item {
            DotaReview()
        }
        item{
            InstallButton()
        }
    }
}

@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent, darkIcons = false)
        systemUiController.setNavigationBarColor(color = Color.Transparent, darkIcons = false)
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = false)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidLaboratoryTheme {
        DotaScreen()
    }
}