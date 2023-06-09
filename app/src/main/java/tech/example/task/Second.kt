package tech.example.task

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Second(navHostController: NavHostController, isDark: Boolean,onClick: ()-> Unit) {
    val fileName = null
    val state = rememberPagerState()
    val context = LocalContext.current
    //var mediaPlayer = MediaPlayer.create(context, R.raw.Janekyu)
    var pdfUri by remember { mutableStateOf<Uri?>(null) }

    val launcherPDF = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->

    }


    val fantasy = mutableListOf<FantasyClass>(
        FantasyClass(
            name1 = "ACOTAR",
            icon1 = R.drawable.acotar,
            link1 = "https://drive.google.com/file/d/1axM7gBdDDhqXWnZcPx2Uwwo4OZxu6hJU/view?usp=share_link"
        ),
        FantasyClass(
            name1 = "Shatter me",
            icon1 = R.drawable.shatterme,
            link1 = "https://drive.google.com/file/d/1avQBC4rHgpkFXo16oImtQH5ZUoDHluMn/view?usp=share_link"),
        FantasyClass(
            name1 = "RED QUEEN",
            icon1 = R.drawable.redqueen,
            link1 = "https://drive.google.com/file/d/1at4_cRK_3l-ZbR1mWqRwIAFWWoN5nB7G/view?usp=share_link"),
        FantasyClass(
            name1 = "GILD",
            icon1 = R.drawable.gild,
            link1 = "https://drive.google.com/file/d/1agc_ihUfX0THPNK8Vn4_kcYIi4HkESwp/view?usp=share_link"),
        FantasyClass(
            name1 = "THE BRIDGE KINGDOM",
            icon1 = R.drawable.bridgekingdom,
            link1 = "https://drive.google.com/file/d/1axM7gBdDDhqXWnZcPx2Uwwo4OZxu6hJU/view?usp=share_link")
    )
    val romance = mutableListOf<RomanceClass>(
        RomanceClass(
            name2 = "BETTER THAN THE MOVIES",
            icon2 = R.drawable.betterthanmovies,
            link2 ="https://drive.google.com/file/d/1aafTkfCBq2qYxx8nmwAojmt0ROAW6tpg/view?usp=share_link"
        ),
        RomanceClass(
            name2 = "ANNA AND THE FRENCH KISS",
            icon2 = R.drawable.annaandfrenchkiss,
            link2 = "https://drive.google.com/file/d/1imH_NGOuxR5Le3M7kIfk3vfxN6LwVc9g/view?usp=share_link"
        ),
        RomanceClass(
            name2 = "THE SPANISH LOVE DECEPTION",
            icon2 = R.drawable.spanishlove,
            link2 = "https://drive.google.com/file/d/1a_r4tMbDpLPOg-oVIy4Z_Jw-Fk2BNrcM/view?usp=share_link"),
        RomanceClass(
            name2 = "THE LOVE HYPOTHESIS",
            icon2 = R.drawable.lovehypothesis,
            link2 = "https://drive.google.com/file/d/1a_CtRixQCuKfwOqRTv3HjJJ3T0LeMtJq/view?usp=share_link"),
        RomanceClass(
            name2 = "ARCHER'S VOICE",
            icon2 = R.drawable.archersvoice,
            link2 = "https://drive.google.com/file/d/1ijAxpH2Q2lpt8DiVYeUF6nJs5Upi4y2v/view?usp=share_link")
    )


    val horror = mutableListOf<HorrorClass>(
        HorrorClass(
            name3 = "VERITY",
            icon3 = R.drawable.verity,
            link3 = "https://drive.google.com/file/d/1aWlARpJX9nHMzGC8FeKuTB-ZEJHpeHzi/view?usp=share_link"),
        HorrorClass(
            name3 = "WILD COUNTRY",
            icon3 = R.drawable.anne,
            link3 = "https://drive.google.com/file/d/1b72p2J2OkDaFJOrkiHZkIwQ1jU-24aN9/view?usp=share_link"),
        HorrorClass(
            name3 = "LAYLA",
            icon3 = R.drawable.layla,
            link3 = "https://drive.google.com/file/d/1lsZT5LgnH7m6UXl9PqSFKD9s6bH840q6/view?usp=share_link"),
        HorrorClass(
            name3 = "THE HAUNTING OF HILL HOUSE",
            icon3 = R.drawable.hauntinghillhouse,
            link3 = "https://drive.google.com/file/d/1bBGAQdjIFqHQi0ALfn-Ulgi5xO3ZYN_O/view?usp=share_link"),
        HorrorClass("THE DEVIL YOU KNOW",
            icon3 =  R.drawable.thedevil,
            link3 = "https://drive.google.com/file/d/1b5irDR90mtK1lkzfCvuG04ZgSVnOzHsR/view?usp=share_link")
    )

    val thriller = mutableListOf<ThrillerClass>(
        ThrillerClass(
            name4 = "THE MOONSTONE",
            icon4 = R.drawable.moonstone,
            link4 = "https://drive.google.com/file/d/1p6_Fw8p9Ypao-f5I4I14McUoY2nfgQCz/view?usp=drivesdk"),
        ThrillerClass(
            name4 ="THE BODY",
            icon4 = R.drawable.thebody,
            link4 = "https://drive.google.com/file/d/1p5RlIkhtQEZ-MG3Sisjes2RRlhjEDkFc/view?usp=drivesdk"),
        ThrillerClass(
            name4 = "GONE GIRL",
            icon4 = R.drawable.gonegirl,
            link4 = "https://drive.google.com/file/d/1b4kMaJ1hTqFeXLM092ZBOf0wYly1DV3e/view?usp=share_link"),
        ThrillerClass(
            name4 = "THE FEVER IN THE WATER",
            icon4 = R.drawable.thefever,
            link4 = "https://drive.google.com/file/d/1b2woIS_3BG9w5qwMea5j1wCx5OANTd1h/view?usp=share_link"),
        ThrillerClass(
            name4 = "A STRANGER IN THE HOUSE",
            icon4 = R.drawable.strangerinhouse,
            link4 = "https://drive.google.com/file/d/1b2dtpp1uUSqftC8J-9q4ZdzZEtJ0BMQn/view?usp=share_link")
    )


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

    val poetry = mutableListOf<PoetryClass>(
        PoetryClass(
            name6 = "VICTORIAN POETRY",
            icon6 = R.drawable.victorianpoetry,
            link6 = "https://drive.google.com/file/d/1pGi3DVUFCFiPCi4K6hxpZU1cjVtEY1VR/view?usp=drivesdk"),
        PoetryClass(
            name6 = "SONG OF RUIN" ,
            icon6 = R.drawable.songofruin,
            link6 = "https://drive.google.com/file/d/1pOYcNH1Dsn7aE1pfeLu1Ss1EYOQefmAk/view?usp=drivesdk"),
        PoetryClass(
            name6 = "WILLIAM SHAKESPEARE",
            icon6 = R.drawable.william,
            link6 = "https://drive.google.com/file/d/1n1sxddkYUQO6G5ikJQrWeixv1-eTmsXV/view?usp=drivesdk"),
        PoetryClass(
            name6 = "POETRY OF PHYSICS",
            icon6 = R.drawable.poetryofphysics,
            link6 = "https://drive.google.com/file/d/1pTTaOBOgn3t8zF9imMfAv5AWmT7Vbufu/view?usp=drivesdk"),
        PoetryClass(
            name6 = "POETRY FOR DUMMIES",
            icon6 = R.drawable.dummies,
            link6 = "https://drive.google.com/file/d/1pQsklRIs9MDYurdNprHBOtPERmBbfwC8/view?usp=drivesdk")
    )


    val scific = mutableListOf<ScificClass>(
        ScificClass(
            name7 = "THE TIME MACHINE",
            icon7 = R.drawable.thetimemachine,
            link7 = "https://drive.google.com/file/d/1mUGbMe9OIAh3l1C-K_FEXVV-uwep06Nd/view?usp=share_link"),
        ScificClass(
            name7 = "THE TIME TRAVELLER'S WIFE",
            icon7 = R.drawable.timetravellerswife,
            link7 = "https://drive.google.com/file/d/1mXnt7EgrqmX5wkT_AzsNWxxjA0WXb91O/view?usp=share_link"),
        ScificClass(
            name7 = "A VOYAGE TO THE MOON",
            icon7 = R.drawable.voyage,
            link7 = "https://drive.google.com/file/d/1p4Y3Xp_4F-qkIuB1DxtjyzaY1O9wpmru/view?usp=share_link"),
        ScificClass(
            name7 = "THE GIRL WHO KNEW TOO MUCH",
            icon7 = R.drawable.thegirlwhoknew,
            link7 = "https://drive.google.com/file/d/1mmIzSOE8gy-ELbDCites7ZHXriRTanwk/view?usp=share_link"),
        ScificClass(
            name7 = "STRANGE WEATHER",
            icon7 = R.drawable.strangeweather,
            link7 = "https://drive.google.com/file/d/1o5WrluJ-pltHX7MUKHaQ7Aa4MHKPsrug/view?usp=share_link")
    )


    val history= mutableListOf<HistoryClass>(
        HistoryClass(
            name8 = "THE CASUAL VACANCY",
            icon8 = R.drawable.casualvacancy,
            link8 = "https://drive.google.com/file/d/1lzccPV0ctQwmqShJpVpoEg9VT08G1YEv/view?usp=share_link"),
        HistoryClass(
            //CHANGE
            name8 = "MODERN INDIA",
            icon8 = R.drawable.modern,
            link8 = "https://drive.google.com/file/d/1nRZefrz0q196LJ8Sz7TmrTjheESd18G9/view?usp=share_link"),
        HistoryClass(
            name8 = "DRAGONFLY",
            icon8 = R.drawable.dragonfly,
            link8 = "https://drive.google.com/file/d/1ngNBoQnAaNViHojpn_-mDe65Ub4Y-s4P/view?usp=share_link"),
        HistoryClass(
            name8 = "WHERE THE LIGHT ENTERS",
            icon8 = R.drawable.wherelight,
            link8 = "https://drive.google.com/file/d/1ndRtJ7mzvPsXtoNuO1UCnzFfoyGXJKaL/view?usp=share_link"),
        HistoryClass(
            name8 = "MISTRESS OF THE RITZ",
            icon8 = R.drawable.mistress,
            link8 = "https://drive.google.com/file/d/1nTNI6OfzvO7uOECZK1W6_pVtOOsWJIal/view?usp=share_link")
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = if (isDark) Color.Black else Color.White)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("book.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp, top = 50.dp)
            )
            Text(
                text = "BOOKSTOP",
                color = if (isDark) Color.White else Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 40.dp, start = 2.dp)
            )
        }

         Row(modifier = Modifier
              .fillMaxWidth()
              .height(50.dp)
              .padding(top = 15.dp, start = 10.dp, end = 10.dp)
              .clip(RoundedCornerShape(15.dp))
             .background(color = if (isDark)  Color.White else Color.LightGray)

          ){
             Icon(imageVector = Icons.Filled.Search,
                 contentDescription = "",
             tint = if (isDark) Color.Black else Color.White,
             modifier = Modifier
                 .padding(start = 15.dp, top =3.dp)
                 .size(23.dp)
             )

                Text(text = "Search here...",
                    fontSize = 17.sp,
                    color =  if (isDark) Color.Black else Color.White ,
                    modifier = Modifier.padding(start = 2.dp, top= 3.dp))
            }



        Row(
            modifier = Modifier
                .width(370.dp)
                .height(50.dp)
                .background(color = if (isDark) Color.Black else Color.White)
                .padding(top = 5.dp, start = 10.dp),


        ) {


            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 3.dp, top = 8.dp)
                    .clip(RoundedCornerShape(50.dp)),
                enabled = true,
                border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium,
            )
            {
                Text(text = "EXPLORE", color =if (isDark) Color.White else Color.Black)
            }
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 3.dp, top = 8.dp)
                    .clip(RoundedCornerShape(50.dp)),
                enabled = true,
                border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "RECENT BOOKS", color =if (isDark) Color.White else Color.Black)
            }
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 3.dp, top = 8.dp)
                    .clip(RoundedCornerShape(50.dp)),
                enabled = true,
                border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium,
            )
            {
                Text(text = "NEW", color = if (isDark) Color.White else Color.Black)
            }
        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState(),
                flingBehavior = ScrollableDefaults.flingBehavior())

        ) {
        LazyRow {
            items(21) { listItem ->
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "",
                    tint = if (isDark) Color.White else Color.Black,
                    modifier = Modifier
                        .padding(start = 2.dp, top = 10.dp, bottom = 10.dp)
                        .size(15.dp))
            }}

                 Card(
                     modifier = Modifier
                         .height(200.dp)
                         .width(400.dp)
                         .background(color = Color.Unspecified)
                         .padding(
                             top = 1.dp, bottom = 2.dp
                         )){

            Image(
                painter = painterResource(id = R.drawable.novels),
                contentDescription = ""
            )
                 }

            LazyRow {
                items(21) { listItem ->
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "",
                        tint = if (isDark) Color.White else Color.Black,
                        modifier = Modifier
                            .padding(start = 2.dp, top = 10.dp, bottom = 10.dp)
                            .size(15.dp))
                }}

            Text(
                text = "ADD YOUR FAVS",
                color = if (isDark) Color.White else Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(top = 10.dp, start = 15.dp)
            )

      Row(  modifier = Modifier
          .horizontalScroll(
              rememberScrollState(),
              flingBehavior = ScrollableDefaults.flingBehavior()
          )
          .fillMaxWidth()
          .height(170.dp)
          .background(color = if (isDark) Color.Black else Color.White)) {


          Card(
              modifier = Modifier
                  .height(180.dp)
                  .width(150.dp)
                  .padding(start = 5.dp, top = 2.dp)
                  .clip(RoundedCornerShape(20.dp))
                  .background(color = if (isDark) Color.Black else Color.White)
          ) {
              Image(painter = painterResource(id = R.drawable.addnew), contentDescription ="",
              modifier = Modifier.clickable {
                  val fileInputStream: FileInputStream =
                      context
                          .getApplicationContext()
                          .openFileInput(fileName)
                  val inputStreamReader = InputStreamReader(fileInputStream)
                  val bufferedReader = BufferedReader(inputStreamReader)
                  val lineData: String = bufferedReader.readLine()
              })
//              Icon(
//                  imageVector = Icons.Outlined.Add,
//                  contentDescription = "",
//                  tint = if (isDark) Color.Gray else Color.White,
//                  modifier = Modifier
//                      .padding(end = 10.dp)
//                      .size(80.dp)
//                      .clickable {
////                          val uri = Uri.parse(getFilesDir() + "my-document.pdf")
////                          val config = PdfActivityConfiguration.Builder(context).build()
////                          PdfActivity.showDocument(this, uri, config)
//
//                          val fileInputStream: FileInputStream =
//                              context
//                                  .getApplicationContext()
//                                  .openFileInput(fileName)
//                          val inputStreamReader = InputStreamReader(fileInputStream)
//                          val bufferedReader = BufferedReader(inputStreamReader)
//                          val lineData: String = bufferedReader.readLine()
//                      })
          } }

          Row(modifier = Modifier
              .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
              .height(45.dp)) {
              Text(
                  text = "Fantasy",
                  color = if (isDark) Color.White else Color.Black,
                  fontSize = 25.sp,
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
                  fontFamily = FontFamily.Serif
              )

              Text(text = "See all",
                  color = if (isDark) Color.LightGray else Color.Gray,
                  modifier = Modifier
                      .padding(start = 170.dp, bottom = 2.dp, top = 5.dp)
                      .clickable { navHostController.navigate(Screens.FantasyScreen.route) }

              )
              Icon(
                  imageVector = Icons.Filled.Add,
                  contentDescription = "",
                  tint = if (isDark) Color.LightGray else Color.Gray,
                  modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
              )
          }
        LazyRow {
            items(fantasy) { listItem ->
                Column(modifier =Modifier.clickable {
                    val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(listItem.link1)
                )
                   context.startActivity(urlIntent) }) {
                    Card(modifier = Modifier
                        .height(200.dp)
                        .width(150.dp)
                        .padding(all = 2.dp)
                      , backgroundColor = if (isDark)  Color.Black else Color.LightGray
                    ) {
                        Icon(
                            painter = painterResource(id = listItem.icon1),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                .height(50.dp)
                                .width(50.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                        Text(
                            text = listItem.name1,
                            color = if (isDark) Color.White else Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(start = 4.dp, top = 155.dp)
                                .align(Alignment.CenterHorizontally)

                    ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Romance",
                    fontSize = 25.sp,
                   color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 165.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.RomanceScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(romance) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link2)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon2),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name2,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)
                        ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Horror",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 190.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.HorrorScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(horror) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link3)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon3),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name3,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)


                        ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Thriller",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 185.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.ThrillerScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(thriller) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link4)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon4),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name4,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)
//                                    .clickable { launcherPDF.launch("acomaf.pdf") }
//                            if (pdfUri != null) {
//                                val file = File(ContentUriUtil.getFilePath(context = context, uri = pdfUri!!)!!)
//                                ComposePDF(file = file)
//                            }


                        ) }} }}

            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Poetry",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 190.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.PoetryScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(poetry) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link6)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon6),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name6,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)

                        ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Sci-Fic",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 190.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.ScificScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }

            LazyRow {
                items(scific) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link7)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon7),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name7,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)


                        ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "Biography",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 145.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.BiographyScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(biography) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link5)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon5),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name5,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)


                        ) }} }}
            Row(modifier = Modifier
                .padding(start = 8.dp, bottom = 2.dp, top = 5.dp)
                .height(45.dp)) {
                Text(
                    text = "History",
                    fontSize = 25.sp,
                    color = if (isDark) Color.White else Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
                Text(text = "See all",
                    color = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier
                        .padding(start = 175.dp, bottom = 2.dp, top = 5.dp)
                        .clickable { navHostController.navigate(Screens.HistoryScreen.route) }

                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = if (isDark) Color.LightGray else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp, top = 5.dp)
                )
            }
            LazyRow {
                items(history) { listItem ->
                    Column(modifier =Modifier.clickable {
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(listItem.link8)
                        )
                        context.startActivity(urlIntent) }) {
                        Card(modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(all = 2.dp)
                            , backgroundColor = if (isDark)  Color.Black else Color.LightGray) {
                            Icon(
                                painter = painterResource(id = listItem.icon8),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .padding(top = 4.dp, start = 10.dp, end = 10.dp, bottom = 40.dp)
                                    .height(50.dp)
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
//                    Card(modifier = Modifier
//                        .height(50.dp)
//                        .width(150.dp)
//                        .padding(start = 4.dp)) {
                            Text(
                                text = listItem.name8,
                                color = if (isDark) Color.White else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(start = 4.dp, top = 155.dp)
                                    .align(Alignment.CenterHorizontally)


                        ) }} }}}}
        }