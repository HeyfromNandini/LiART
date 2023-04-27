package tech.example.task

import android.app.ProgressDialog.show
import android.content.Intent
import android.net.Uri
import android.view.Gravity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle

import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import io.github.farhanroy.composepdf.ComposePDF
import java.io.File


@Composable
fun LoginPage(navHostController: NavHostController, isDark: Boolean, onClick: ()-> Unit ) {
    var name by remember {
        mutableStateOf("")
    }
//    Button(onClick = {
//        navHostController.popBackStack() // to directly end the app process
//        navHostController.navigate(Screens.SecondScreen.route.plus(
//            "?${Constants.Name.value}=$name"
//        ))
//    }) {
//        Text(text = "Click Me", color = Color.White)
//    }
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.Black)
//            .clickable {
//                navHostController.navigate(Screens.ThirdScreen.route)
//            }
    val context = LocalContext.current
    val viewModel = viewModel<OneShotOperationViewModel>()
    LaunchedEffect(Unit) {
        viewModel
            .toastMessage
            .collect { message ->
                Toast.makeText(
                    context,
                    message,
                    Toast.LENGTH_SHORT,
                )//.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
            }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .background(color = if (isDark) Color.Black else Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .width(500.dp)
                .padding(top = 50.dp, start = 15.dp)
        ) {
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("theme.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(45.dp)
                    .padding(2.dp)
                    .clickable {
                        onClick()
                    }

            )
        }
        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("relax.json")
        )
        val progress by animateLottieCompositionAsState(compnotify)
        LottieAnimation(
            composition = compnotify,
            iterations = Int.MAX_VALUE,
            isPlaying = true,
            contentScale = ContentScale.Crop,
            speed = 1.45f,
            modifier = Modifier
                .size(350.dp)
                .padding(end = 10.dp, top = 10.dp, start = 10.dp)
        )
        //  Toast.makeText(context, "Welcome to LiART!!", Toast.LENGTH_LONG).show()
        viewModel.sendMessage("Welcome to LiART!!")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(2.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "LiART", fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                color = if (isDark) Color.White else Color.Black,
                fontSize = 60.sp
            )
        }
        Text(
            text = "Don't wait for NO ONE.",
            color = if (isDark) Color.White else Color.Black,
            fontSize = 20.sp
        )
        Text(
            text = "Deep dive in your own world!!!!",
            color = if (isDark) Color.White else Color.Black,
            fontSize = 20.sp
        )


    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 2.dp, start = 30.dp, bottom = 100.dp), Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 30.dp)//.align(Alignment.BottomCenter)
        ) {
            val context = LocalContext.current
            Button(
                onClick = {


                    viewModel.sendMessage("Get ready to feel the magic")
                    //   Toast.makeText(context, "Get ready to feel the magic", Toast.LENGTH_LONG).show()
                    navHostController.popBackStack() // to directly end the app process
                    navHostController.navigate(Screens.SignupScreen.route)

                },
                modifier = Modifier.padding(all = 10.dp),
                enabled = true,
                border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium

            )
            {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "",
                    tint = if (isDark) Color.White else Color.Black,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(text = "SIGN UP", color = Color.White)

            }

            Button(
                onClick = {
                   // viewModel.sendMessage("Glad to have you back!!!")
                    //  Toast.makeText(context, "Glad to have you back!!!", Toast.LENGTH_LONG).show()
//                    val urlIntent = Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("https://drive.google.com/file/d/1lmwq9ha4VxGfIZUtKPgx-4dBq_s1mO0i/view?usp=share_link")
//                    )
//                   context.startActivity(urlIntent)
                       navHostController.popBackStack() // to directly end the app process
                        navHostController.navigate(Screens.SignupScreen.route)

                },

                modifier = Modifier.padding(all = 10.dp),
                enabled = true,
                border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
                shape = MaterialTheme.shapes.medium,
            )
            {

                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "",
                    tint = if (isDark) Color.White else Color.Black,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(text = "SIGN IN", color = Color.White)

            }

        }
    }


}

