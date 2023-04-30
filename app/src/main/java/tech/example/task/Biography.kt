package tech.example.task

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun Biography(navHostController: NavHostController, isDark: Boolean,onClick: ()-> Unit){
    val context = LocalContext.current
    val biography = mutableListOf<BiographyClass>(
        BiographyClass(
            name5 = "SARDAR VALLABBHAI PATEL",
            icon5 = R.drawable.sardar,
            link5 = "https://drive.google.com/file/d/1mQLGqKfzDAeE2yb7hwDPA-PwxWs_G67S/view?usp=share_link"),
        BiographyClass(
            name5 =  "WINGS OF FIRE",
            icon5 = R.drawable.wingsoffire,
            link5 = "https://drive.google.com/file/d/1m3ShOhBqTF3LiINzOkvEaA9k88FD4R11/view?usp=share_link"),
        BiographyClass(
            name5 = "ALBERT EINSTEIN",
            icon5 = R.drawable.albert,
            link5 = "https://drive.google.com/file/d/1m5b-hUYMwu2gIMgan47dR6cmK2xWInir/view?usp=share_link"),
        BiographyClass(
            name5 = "ABRAHM LINCOLN",
            icon5 = R.drawable.abrahamlincoln,
            link5 = "https://drive.google.com/file/d/1mHVMNt08ei4ejHZ1lbeFsN5_JgCADJRR/view?usp=share_link"),
        BiographyClass(
            name5 = "THE HAPPIEST MAN ON EARTH",
            icon5 = R.drawable.happiestman,
        link5 = "https://drive.google.com/file/d/1o2RQv2dEYl05aLm_OhSmsmIjvm88R7FL/view?usp=share_link")
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isDark) Color.Black else Color.White)
    ) {
        Row() {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                tint = if (isDark) Color.White else Color.Black,
                modifier = Modifier
                    .padding(start = 15.dp, top = 35.dp)
                    .size(40.dp)
                    .clickable { navHostController.navigate(Screens.SecondScreen.route) }
            )
            Text(
                textAlign = TextAlign.Start,
                text = "BIOGRAPHY", fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                color = if (isDark) Color.White else Color.Black,
                fontSize = 40.sp, modifier = Modifier
                    .padding(start = 1.dp, top = 30.dp)
            )
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("magicbook.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(120.dp)
                    .padding( top = 5.dp, end = 30.dp).padding(2.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(start = 2.dp, top = 1.dp)
                    .height(200.dp)
                    .width(450.dp)
                    .clip(RoundedCornerShape(50.dp)),
                backgroundColor = if (isDark) Color.Black else Color.White,
                border = BorderStroke(width = 1.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.biography), contentDescription = "",
                    modifier = Modifier.clip(RoundedCornerShape(50.dp))
                )
            }
        }
        LazyColumn {
            items(biography) { listItem ->
                Row {
                    Card(
                        modifier = Modifier
                            .height(180.dp)
                            .width(120.dp)
                            .padding(start = 5.dp, top = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = listItem.icon5),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                    }
                    Card(
                        modifier = Modifier
                            .height(180.dp)
                            .width(200.dp)
                            .padding(start = 10.dp, top = 20.dp, bottom = 20.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        backgroundColor = if (isDark)  Color.Black else Color.LightGray,
                        border = BorderStroke(width = 1.dp, brush = SolidColor(if (isDark) Color.White else Color.Black))

                    ) {
                        Text(
                            text = listItem.name5,
                            color = if (isDark) Color.White else Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,

                            modifier = Modifier
                                .padding(start = 30.dp, top = 30.dp)
                            //   modifier = Modifier.padding(3.dp).padding(5.dp)
                        )
                        Button(
                            onClick = {
                                val urlIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(listItem.link5)
                                )

                                context.startActivity(urlIntent)
                            },
                            modifier = Modifier.height(40.dp).width(30.dp)
                                .padding(top = 85.dp, start = 30.dp, bottom = 18.dp, end = 50.dp),
                            enabled = true,
                            border = BorderStroke(width = 1.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                            shape = MaterialTheme.shapes.medium


                        ){
                            Text(text = "Open PDF", color = if (isDark) Color.White else Color.Black)
                        }
                    }
                }
                Row(modifier = Modifier
                    .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                    .height(10.dp)) {
                }
            }
        }

    }
}

