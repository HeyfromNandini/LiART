package tech.example.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

        LazyColumn{
            items(searchResults){results ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = results.name, color = Color.White, modifier = Modifier.padding(15.dp))
                    Text(text = results.emailID, color = Color.White, modifier = Modifier.padding(15.dp))
                    Text(text = results.phoneValue, color = Color.White, modifier = Modifier.padding(15.dp))
                }
            }
        }

    }}