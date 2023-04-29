package tech.example.task

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString
import com.pspdfkit.internal.e6

sealed class Screens(val route: String){
    object LoginPage: Screens("first")
    object SignupScreen:Screens("signup")
    object ProfileScreen:Screens("profile")
    object SecondScreen: Screens("second")
    object FantasyScreen: Screens("fantasy")
    object RomanceScreen: Screens("romance")
    object HorrorScreen: Screens("horror")
    object ThrillerScreen: Screens("thriller")
    object PoetryScreen: Screens("poetry")
    object ScificScreen: Screens("scific")
    object BiographyScreen: Screens("biography")
    object HistoryScreen: Screens("history")
}
sealed class Constants(val value: String){
    object Name: Constants("name")
}

//data class ProfileModel(
//    var age: String,
//    var name: String,
//    var email: String,
//)
//
//data class UserModel(
//    var profile: ProfileModel
//)

data class ImageClass(
    @DrawableRes val imageId:Int,
    val contentDescription:String? = null
)




data class FantasyClass(
    val name1: String,
    val icon1: Int,
    val link1:String
)
data class RomanceClass(
    val name2: String,
    val icon2: Int,
    val link2 : String
)
data class HorrorClass(
    val name3: String,
    val icon3: Int,
    val link3 : String
)
data class ThrillerClass(
    val name4: String,
    val icon4: Int,
    val link4 : String
)
data class BiographyClass(
    val name5: String,
    val icon5: Int,
    val link5 : String
)
data class PoetryClass(
    val name6: String,
    val icon6: Int,
    val link6 : String
)
data class ScificClass(
    val name7: String,
    val icon7: Int,
    val link7 : String
)
data class HistoryClass(
    val name8: String,
    val icon8: Int,
    val link8 : String
)