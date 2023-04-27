import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
import java.time.format.TextStyle

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



//    LazyColumn{
//        items(searchResults){results ->
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(text = results.name, color = Color.White, modifier = Modifier.padding(15.dp))
//                Text(text = results.emailID, color = Color.White, modifier = Modifier.padding(15.dp))
//                Text(text = results.phoneValue, color = Color.White, modifier = Modifier.padding(15.dp))
//            }
//        }
//    }

    Column(modifier = Modifier
        .background(color = if (isDark) Color.Black else Color.White)
        .fillMaxSize()) {

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
                .size(350.dp)
                .padding( top = 10.dp, start = 20.dp)
        )

        Column(
            modifier = Modifier
                .verticalScroll(
                    rememberScrollState(),
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
                .fillMaxWidth()
                .background(color =  if (isDark) Color.Black else Color.White)
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
                        color =if (isDark) Color.Gray else Color.Black
                    )
                },
                placeholder = { Text(text = "Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            OutlinedTextField(
                value = emailValue.value,
                colors = TextFieldDefaults.textFieldColors(if (isDark)  Color.White else Color.Black),
                onValueChange = {
                    emailValue.value = it
                },
                label = { Text(text = "Email Address",
                    color =if (isDark) Color.Gray else Color.Black) },
                placeholder = { Text(text = " Email Address") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f)
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
                placeholder = { Text(text = "Phone Number", fontSize = 20.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
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
                placeholder = { Text(text = "Password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
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
            onClick = {viewModel.insertStudent(
                name = nameValue.value,
                email = emailValue.value,
                phoneValue = phoneValue.value)
                 navHostController.navigate(Screens.SecondScreen.route)
            },
            modifier = Modifier.fillMaxWidth(0.8f).height(60.dp).padding(top = 15.dp, start = 55.dp),
            enabled = true,
            border = BorderStroke(width = 2.dp, brush = SolidColor(if (isDark) Color.White else Color.Black)),
            shape = MaterialTheme.shapes.medium

        ){
            Text(text = "LET'S GO!!", color = if (isDark) Color.White else Color.Black)
        }
        Box(modifier =Modifier
            .fillMaxSize(),
            Alignment.BottomCenter )
        {
            Row(modifier = Modifier
                ,
                horizontalArrangement = Arrangement.Center)
            {

                Text(text = "Enjoy your experience",
                    fontSize = 18.sp,
                    color = if (isDark) Color.Gray else Color.Black ,
                    modifier = Modifier
                        .padding( start = 10.dp, bottom = 30.dp))
                val compnotify by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("heart.json")
                )
                val progress by animateLottieCompositionAsState(compnotify)
                LottieAnimation(
                    composition = compnotify,
                    iterations = 1,
                    isPlaying = true,
                    contentScale = ContentScale.Crop,
                    speed = 1.45f,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(start = 10.dp)
                )
            }
        }

    }
}











