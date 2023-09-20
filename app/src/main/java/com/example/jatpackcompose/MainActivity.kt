package com.example.jatpackcompose

import android.icu.number.NumberFormatter.with
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.toSize
import androidx.core.content.ContextCompat
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContent {
            Surface(
                modifier = Modifier
                    .background(
                        color = Color.Green
                    )
                    .fillMaxSize(),
                color = MaterialTheme.colors.surface
            ) {
//                GreetingPreview()
                businessCard()
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true)
@Composable
fun businessCard() {

    var parentSize by remember {
        mutableStateOf(Size.Zero)
    }
    val image = painterResource(id = R.drawable.android_logo)
    val call = painterResource(id = R.drawable.baseline_call_24)
    val email = painterResource(id = R.drawable.baseline_email_24)
    val share = painterResource(id = R.drawable.baseline_share_24)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#" + "FFd2e9d4")))

    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .fillMaxHeight()
                .weight(1f)

        ) {
            //Logo and title
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(android.graphics.Color.parseColor("#" + "FF083143")))
                        .onGloballyPositioned {
                            //here u can access the parent layout coordinate size
                            parentSize = it.parentLayoutCoordinates?.size?.toSize() ?: Size.Zero
                        }
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alpha = 0.8F
                        )
                        Text(text = "parent size  = $parentSize")
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Hardik Chitroda", color = Color.Black, fontSize = 35.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Android Developer Extraordinaire",
                    color = Color(android.graphics.Color.parseColor("#" + "FF227b4d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
//            modifier = Modifier.background(Color(android.graphics.Color.parseColor("#" + "FF227b4d")))
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(
                    all = 40.dp
                )
        ) {
            //Contact info
            Row() {
                Image(
                    painter = call,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.8F
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    "+91 8866294760",
                    style = TextStyle(
                        fontSize = 15.sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                Image(
                    painter = share,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.8F
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    "@HarryGrey",
                    style = TextStyle(
                        fontSize = 15.sp
                    ),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                Image(
                    painter = email,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.8F
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    "harry@grey.com", style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
        }
    }



//
//    Column(modifier = Modifier.background(Color(android.graphics.Color.parseColor("#" + "FF227b4d")))) {
//
//
//        /*      Surface(
//                  modifier = Modifier.fillMaxSize(),
//                  color = MaterialTheme.colors.background
//              ) {
//                  var parentSize by remember {
//                      mutableStateOf(Size.Zero)
//                  }
//                  Box(
//                      modifier = Modifier
//                          .fillMaxWidth()
//                          .aspectRatio(1f)
//                          .background(Color.Green)
//                  ) {
//                      Box(
//                          modifier = Modifier
//                              .size(100.dp)
//                              .align(Alignment.Center)
//                              .background(Color.Red)
//                              .onGloballyPositioned {
//                                  //here u can access the parent layout coordinate size
//                                  parentSize = it.parentLayoutCoordinates?.size?.toSize()?: Size.Zero
//                              }
//                      ) {
//                          Column(Modifier.fillMaxSize()) {
//                              Text(text = "parent size  = $parentSize")
//                          }
//                      }
//                  }
//              }
//
//              */
//
//        var parentSize by remember {
//            mutableStateOf(Size.Zero)
//        }
//        val image = painterResource(id = R.drawable.android_logo)
//
////FFd2e9d4
//        Column(
//            modifier = Modifier
//                .padding(10.dp)
//                .background(Color(android.graphics.Color.parseColor("#" + "FFd2e9d4")))
//
//        ) {
//            LazyColumn(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .padding(5.dp)
//                    .align(alignment = Alignment.CenterHorizontally)
//                    .fillMaxHeight()
//            ) {
//                item {
//                   Column(
//                       modifier = Modifier
//                           .fillMaxSize()
//                           .fillMaxHeight()
//                           .background(Color(android.graphics.Color.parseColor("#" + "FF227b4d")))
//                   ) {
//                       Box(
//                           modifier = Modifier
//                               .size(100.dp)
//                               .background(Color(android.graphics.Color.parseColor("#" + "FF083143")))
//                               .onGloballyPositioned {
//                                   //here u can access the parent layout coordinate size
//                                   parentSize = it.parentLayoutCoordinates?.size?.toSize() ?: Size.Zero
//                               }
//                       ) {
//                           Column(
//                               Modifier
//                                   .fillMaxSize()
//                                   .padding(10.dp)
//                           ) {
//                               Image(
//                                   painter = image,
//                                   contentDescription = null,
//                                   contentScale = ContentScale.Crop,
//                                   alpha = 0.8F
//                               )
//                               Text(text = "parent size  = $parentSize")
//                           }
//                       }
//
//                       Text(text = "Jennifer Doe", color = Color.Black, fontSize = 35.sp)
//                       Text(
//                           text = "Android Developer Extraordinaire",
//                           color = Color(android.graphics.Color.parseColor("#" + "FF227b4d")),
//                           fontSize = 13.sp,
//                           fontWeight = FontWeight.Bold
//                       )
//                   }
//                }
//
//                item {
//                   Column(
//                       modifier = Modifier
//                           .background(Color(android.graphics.Color.parseColor("#" + "FF227b4d")))
//                   ) {
//                       Text(text = "Jennifer Doe", color = Color.Black, fontSize = 35.sp)
//                       Text(
//                           text = "Android Developer Extraordinaire",
//                           color = Color(android.graphics.Color.parseColor("#" + "FF227b4d")),
//                           fontSize = 13.sp,
//                           fontWeight = FontWeight.Bold
//                       )
//                   }
//                }
//            }
//
//        }
//
//
//    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8F
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(25.dp)
                .align(alignment = Alignment.Center)
        ) {
            Text(
                text = "Happy Birthday. Many many happy returns of the day",
                color = Color.Blue,
                fontSize = 30.sp,
                lineHeight = 50.sp
            )
            Text(text = "Harry", color = Color.Yellow, fontSize = 35.sp)

            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                Text("Some text", color = Color.White)
//            Size(5)
                Text("Some more text", color = Color.White)
//            Size(5)
                Text("Last text", color = Color.White)
            }

            Text(
                text = stringResource(R.string.thank_you),
                fontSize = 36.sp,
                color = Color.Green,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }

}


