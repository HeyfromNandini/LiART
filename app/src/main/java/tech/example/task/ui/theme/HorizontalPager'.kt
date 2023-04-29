package tech.example.task.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay
import tech.example.task.HorrorClass
import tech.example.task.ImageClass
import tech.example.task.R
import tech.example.task.Screens
//
//@OptIn(ExperimentalPagerApi::class)
//
//
//@Composable
//fun HorizontalPager(
//    items: List<ImageClass>,
//    pagerState: PagerState,
//    modifier: Modifier
//){
//    val Image = mutableListOf<ImageClass>(
//       ImageClass(
//            imageId = R.drawable.novels,
//            contentDescription = "To the moon and never back"),
//        ImageClass(
//            imageId = R.drawable.novels,
//            contentDescription = "To the moon and never back"),
//        ImageClass(
//        imageId = R.drawable.horror,
//        contentDescription = "To a whole new level of fear")
//    )
//    var nextPage by remember { mutableStateOf(1) }
//LaunchedEffect(key1 = nextPage ){
//    delay(2000)
//    pagerState.animateScrollToPage(nextPage).also { nextPage=(nextPage+1) % items.size }
//}
//HorizontalPager(
//
//    count = items.size,
//    state = pagerState,
//     modifier = modifier.wrapContentHeight()
//){ page ->
//
//   Column(
//       horizontalAlignment = Alignment.CenterHorizontally,
//       modifier= Modifier
//           .fillMaxSize()
//           .padding(20.dp),
//       verticalArrangement = Arrangement.SpaceEvenly
//   ){
//Image(
//    painter = painterResource(id = items[page].imageId) ,
//    contentDescription = items[page].contentDescription,
//    modifier = Modifier.size(230.dp)
//)
//       Spacer(modifier = Modifier.height(40.dp))
//
//   }
//}
//}
//
////@OptIn(ExperimentalPagerApi::class)
////fun HorizontalPager(count: Int, state: PagerState, modifier: Modifier, any: Any) {
////    TODO("Not yet implemented")
////}
