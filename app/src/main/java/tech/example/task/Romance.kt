package tech.example.task

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Romance(navHostController: NavHostController, isDark: Boolean,onClick: ()-> Unit) {

    val romance = mutableListOf<RomanceClass>(
        RomanceClass(
            name2 = "BETTER THAN THE MOVIES",
            icon2 = R.drawable.betterthanmovies,
            link2 ="https://drive.google.com/file/d/1aafTkfCBq2qYxx8nmwAojmt0ROAW6tpg/view?usp=share_link"
        ),
        RomanceClass(
            name2 = "ANNA AND THE FRENCH KISS",
            icon2 = R.drawable.annaandfrenchkiss,
            link2 = ""
        ),
        RomanceClass(
            name2 = "THE SPANISH LOVE DECEPTION",
            icon2 = R.drawable.spanishlove,
            link2 = ""),
        RomanceClass(
            name2 = "THE LOVE HYPOTHESIS",
            icon2 = R.drawable.lovehypothesis,
            link2 = ""),
        RomanceClass(
            name2 = "ARCHER'S VOICE",
            icon2 = R.drawable.archersvoice,
            link2 = "")
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row() {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.padding(start = 15.dp, top = 35.dp).size(40.dp)
                    .clickable {  navHostController.navigate(Screens.SecondScreen.route) }
            )
            Text(
                textAlign = TextAlign.Start,
                text = "ROMANCE", fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                fontSize = 40.sp, modifier = Modifier
                    .padding(start = 1.dp, top = 30.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(start=2.dp, top = 10.dp)
                    .height(200.dp)
                    .width(450.dp)
                    .clip(RoundedCornerShape(50.dp)),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.romance), contentDescription = "",
                    modifier = Modifier.clip(RoundedCornerShape(50.dp))
                )
            }
        }
        LazyColumn {
            items(romance) { listItem ->
                Row {
                    Card(
                        modifier = Modifier
                            .height(180.dp)
                            .width(120.dp)
                            .padding(start = 5.dp, top = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = listItem.icon2),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .fillMaxSize().padding(4.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                    }
                    Card(
                        modifier = Modifier
                            .height(180.dp)
                            .width(200.dp)
                            .padding(start = 10.dp, top = 20.dp, bottom = 20.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.White)),

                        ) {
                        Text(
                            text = listItem.name2,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,

                            modifier = Modifier
                                .padding(start = 30.dp, top = 30.dp)
                            //   modifier = Modifier.padding(3.dp).padding(5.dp)
                        )
                    }
                }


            }
        }
    }
}


