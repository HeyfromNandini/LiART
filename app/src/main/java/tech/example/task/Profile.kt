package tech.example.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Profile(navHostController: NavHostController,viewModel: MainViewModel, isDark: Boolean, onClick: ()-> Unit){

    Column(modifier = Modifier
        .background(color = if (isDark) Color.Black else Color.White)
        .fillMaxSize()) {
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


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .width(500.dp)
                .padding(top = 50.dp, start = 15.dp)
        ) {
            Text(
                text = "WELCOME TO THE COMMUNITY!!!",
                color = if (isDark) Color.White else Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(top = 10.dp, start = 15.dp)
            )
        }
        LazyColumn{
            items(searchResults){results ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = results.name, color = Color.White, modifier = Modifier.padding(5.dp))
                    Text(text = results.emailID, color = Color.White, modifier = Modifier.padding(5.dp))
                    Text(text = results.phoneValue, color = Color.White, modifier = Modifier.padding(5.dp))
                    Text(text = results.passwordValue, color = Color.White, modifier = Modifier.padding(5.dp))
                }
            }
        }

    }}