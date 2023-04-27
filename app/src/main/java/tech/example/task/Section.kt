package tech.example.task

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Section() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        var color = Color.Black;
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(2.dp).padding(2.dp)

        ) {
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(40.dp)
                    .width(40.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ){
                Image(painter = painterResource(id = R.drawable.goback), contentDescription ="" )
            }
        }
        Row(modifier = Modifier
            .padding(2.dp).padding(2.dp)
            .fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fantasy),
                    contentDescription = "fantasy",
                    modifier = Modifier.clip(RoundedCornerShape(50.dp))
                )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of fantasy", Toast.LENGTH_LONG).show()
            }
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.romance),
                    contentDescription = "romance"
                )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of romance", Toast.LENGTH_LONG).show()
            }

        }
        Row(modifier = Modifier
            .padding(2.dp).padding(2.dp)
            .fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.horror),
                    contentDescription = "horror"
                )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of horror", Toast.LENGTH_LONG).show()
            }
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.thriller),
                    contentDescription = "thriller"
                    )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of thriller", Toast.LENGTH_LONG).show()
            }}
        Row(modifier = Modifier
            .padding(2.dp).padding(2.dp)
            .fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poetry),
                    contentDescription = "poetry",

                )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of poetry", Toast.LENGTH_LONG).show()
            }
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.biography),
                    contentDescription = "biography",
                   )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of biography", Toast.LENGTH_LONG).show()
            }}
        Row(modifier = Modifier
            .padding(2.dp).padding(2.dp)
            .fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.scific),
                    contentDescription = "sci-fic"
                )
                val context = LocalContext.current
                Toast.makeText(context, "Deep dive into the world of Sci-fic", Toast.LENGTH_LONG).show()
            }
            Card(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp),
                backgroundColor = Color.Black,
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.White)),
                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(id = R.drawable.history),
                    contentDescription = "History",
                    )
                val context = LocalContext.current
                Toast.makeText(context, "Create your own history", Toast.LENGTH_LONG).show()
            }}

    }}
