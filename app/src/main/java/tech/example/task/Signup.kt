import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import tech.example.task.MainViewModel
import tech.example.task.R
import tech.example.task.Screens

@Composable
fun Signup(navHostController: NavHostController, viewModel: MainViewModel, isDark: Boolean, onClick: ()-> Unit) {



    val image = painterResource(id = R.drawable.fantasy)
    var nameValue = remember { mutableStateOf("") }
    val searchResults by viewModel.searchResult.collectAsState(initial = listOf())
    var emailValue = remember { mutableStateOf("") }
    var phoneValue = remember { mutableStateOf("") }
    var passwordValue = remember { mutableStateOf("") }
    var confirmPasswordValue = remember { mutableStateOf("") }
    val it = remember { mutableStateOf("String") }
    //
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }



    Column(modifier = Modifier
        .background(color = if (isDark) Color.Black else Color.White)
        .fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .width(500.dp)
                .padding(top = 50.dp, start = 2.dp)
        ) {
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("profile.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(55.dp)
                    .padding(2.dp)
                    .clickable {
                        navHostController.navigate(Screens.ProfileScreen.route)
                    })

            Text(
                text = "JOIN THE COMMUNITY!!!!",
                color = if (isDark) Color.White else Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding( start = 1.dp)
            )
        }
        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("stylebook.json")
        )
        val progress by animateLottieCompositionAsState(compnotify)
        LottieAnimation(
            composition = compnotify,
            iterations = Int.MAX_VALUE,
            isPlaying = true,
            contentScale = ContentScale.Crop,
            speed = 1.45f,
            modifier = Modifier

                .size(300.dp)
                .padding( start = 20.dp, top = 1.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .width(500.dp)
                .padding(top = 1.dp, start = 1.dp)
        ) {
            Text(
                text = "DISCLAIMER: *These details are present to whole community to network, if you don't wanna share your details just click on the button and continue reading.*",
                color = if (isDark) Color.LightGray else Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(  end = 1.dp)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(
                    rememberScrollState(),
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
                .fillMaxWidth()
                .background(color = if (isDark) Color.Black else Color.White)
                .padding(start = 15.dp)
        ) {
            OutlinedTextField(
                value = nameValue.value,
                colors = TextFieldDefaults.textFieldColors(if (isDark)  Color.White else Color.Black),
                onValueChange = {
                    nameValue.value = it
                },
                label = {
                    Text(
                        text = "Name",
                        color =if (isDark) Color.Gray else Color.Black,

                    )
                },
                placeholder = { Text(text = "Name", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp)
            )
            OutlinedTextField(
                value = emailValue.value,
                colors = TextFieldDefaults.textFieldColors(if (isDark)  Color.White else Color.Black),
                onValueChange = {
                    emailValue.value = it
                },
                label = { Text(text = "Email Address",
                    color =if (isDark) Color.Gray else Color.Black) },
                placeholder = { Text(text = "Email Address", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp),

                //      .border(width = 1.dp, color = if (isDark) Color.White else Color.Black)
            )
            OutlinedTextField(
                value = phoneValue.value,
                colors = TextFieldDefaults.textFieldColors(if (isDark)  Color.White else Color.Black),
                onValueChange = {
                    phoneValue.value = it
                },
                label = {
                    Text(text = "Phone Number",
                        color =if (isDark) Color.Gray else Color.Black)
                },
                placeholder = { Text(text = "Phone Number", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = passwordValue.value,
                colors = TextFieldDefaults.textFieldColors(if (isDark)  Color.White else Color.Black),
                onValueChange = {
                    passwordValue.value = it
                },
                label = { Text(text = "Password",
                    color =if (isDark) Color.Gray else Color.Black) },
                placeholder = { Text(text = "Password", fontSize = 14.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "visible",
                            Modifier.size(25.dp),
                            tint =  if (isDark) Color.Gray else Color.Black
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )
//            OutlinedTextField(
//                value = confirmPasswordValue.value,
//                colors = TextFieldDefaults.textFieldColors( if (isDark)  Color.White else Color.Black),
//                onValueChange = { confirmPasswordValue.value = it },
//                label = {
//                    Text(text = "Confirm Password",
//                        color =if (isDark) Color.Gray else Color.Black)
//                },
//                placeholder = {
//                    Text(text = "Confirm Password")
//                },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth(0.9f),
//                trailingIcon = {
//                    IconButton(onClick = {
//                        confirmPasswordVisibility = !confirmPasswordVisibility
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.Info,
//                            contentDescription = "visible",
//                            Modifier.size(25.dp),
//                            tint =  if (isDark)  Color.Gray else Color.Black
//                        )
//                    }
//                })
        }
        Button(
        onClick = {
            viewModel.insertReader(
                name = nameValue.value,
                email = emailValue.value,
                phoneValue = phoneValue.value,
                passwordValue = passwordValue.value
            )
            navHostController.navigate(Screens.SecondScreen.route)
        },

            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
                .padding(top = 15.dp, start = 55.dp),
            enabled = true,
            border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
            shape = MaterialTheme.shapes.medium

        ){
            Text(text = "LET'S GO!!", color = if (isDark) Color.White else Color.Black)
        }

        Row(modifier = Modifier.padding(start = 30.dp),
            horizontalArrangement = Arrangement.Center)
        {

            Text(text = "Enjoy your experience",
                fontSize = 18.sp,
                color = if (isDark) Color.Gray else Color.Black ,
                modifier = Modifier
                    .padding( start = 10.dp, top = 20.dp))
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("heart.json")
            )
            val progress by animateLottieCompositionAsState(compnotify)
            LottieAnimation(
                composition = compnotify,
                iterations = Int.MAX_VALUE,
                isPlaying = true,
                contentScale = ContentScale.Crop,
                speed = 1.45f,
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 1.dp)
            )

        }
    }

}













