package com.example.jatpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class BusinessCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_business_card)

        setContent {
            Surface(
                modifier = Modifier
                    .background(
                        color = Color.Green
                    )
                    .fillMaxSize(),
                color = MaterialTheme.colors.surface
            ) {
                businessCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun businessCard(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Color.Yellow)) {

    }
}