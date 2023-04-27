package tech.example

import Signup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import tech.example.task.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavController(viewModel: MainViewModel) {
    val navController = rememberAnimatedNavController()
    val isDark = isSystemInDarkTheme()
    var dark by remember {
        mutableStateOf(isDark)
    }
    val systemUiController = rememberSystemUiController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.LoginPage.route
    ) {
        composable(
            route = Screens.LoginPage.route
        ) {
           LoginPage(navHostController = navController, isDark = dark){
               dark = !dark
              systemUiController.setSystemBarsColor(
                   if (dark) Color.Black else Color.White
               )
           }
        }
        composable(route = Screens.SignupScreen.route){//.plus(
          //  "?${Constants.Name.value}={name}"
//        ), arguments = listOf(
//            navArgument("name"){
//                this.type = NavType.StringType
//            }
//        )) { backStackEntry ->
//            val name = backStackEntry.arguments?.getString("name") ?: "Nandini"
//            Second(second= name)
        Signup(navHostController =navController , viewModel =viewModel,isDark = dark){
            dark = !dark
            systemUiController.setSystemBarsColor(
                if (dark) Color.Black else Color.White
            )
        }
        }
        composable(route = Screens.SecondScreen.route) {
          Second(navHostController = navController, isDark = dark){
              dark = !dark
              systemUiController.setSystemBarsColor(
                  if (dark) Color.Black else Color.White
              )
          }
        }
        composable(route = Screens.FantasyScreen.route) {
         Fantasy(navHostController = navController, isDark = dark){
             dark = !dark
             systemUiController.setSystemBarsColor(
                 if (dark) Color.Black else Color.White
             )
         }
        }
        composable(route = Screens.RomanceScreen.route) {
          Romance(navHostController = navController, isDark = dark){
              dark = !dark
              systemUiController.setSystemBarsColor(
                  if (dark) Color.Black else Color.White
              )
          }
        }
        composable(route = Screens.HorrorScreen.route) {
           Horror(navHostController = navController, isDark = dark){
               dark = !dark
               systemUiController.setSystemBarsColor(
                   if (dark) Color.Black else Color.White
               )
           }
        }
        composable(route = Screens.ThrillerScreen.route) {
          Thriller(navHostController = navController, isDark = dark){
              dark = !dark
              systemUiController.setSystemBarsColor(
                  if (dark) Color.Black else Color.White
              )
          }
        }
        composable(route = Screens.PoetryScreen.route) {
          Poetry(navHostController = navController, isDark = dark){
              dark = !dark
              systemUiController.setSystemBarsColor(
                  if (dark) Color.Black else Color.White
              )
          }
        }
        composable(route = Screens.ScificScreen.route) {
           Scific(navHostController = navController, isDark = dark){
               dark = !dark
               systemUiController.setSystemBarsColor(
                   if (dark) Color.Black else Color.White
               )
           }
        }
        composable(route = Screens.BiographyScreen.route) {
           Biography(navHostController = navController, isDark = dark){
               dark = !dark
               systemUiController.setSystemBarsColor(
                   if (dark) Color.Black else Color.White
               )
           }
        }
        composable(route = Screens.HistoryScreen.route) {
         History(navHostController = navController, isDark = dark){
             dark = !dark
             systemUiController.setSystemBarsColor(
                 if (dark) Color.Black else Color.White
             )
         }
        }
    }}
