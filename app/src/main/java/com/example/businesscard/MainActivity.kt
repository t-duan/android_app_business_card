package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        "Full Name",
                        "Title",
                        "+123-456-7890",
                        "tinghui.duan@gmail.com",
                        "https://github.com/t-duan"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, email: String, web: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box {
            Column {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(180.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(top = 32.dp, bottom = 8.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
        }
        Box (
            modifier = modifier
                .padding(top = 150.dp)
        ) {
            Column {
                Row {
                    Icon(
                        Icons.Rounded.Phone,
                        contentDescription = null,
                        modifier = modifier
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = phone,
                        modifier = modifier
                            .padding(bottom = 8.dp)
                    )
                }
                Row {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = null,
                        modifier = modifier
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = email,
                        modifier = modifier
                            .padding(bottom = 8.dp)
                    )
                }
                Row {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = null,
                        modifier = modifier
                            .padding(end = 8.dp)
                    )

                    val context = LocalContext.current
                    val uriHandler = LocalUriHandler.current

                    Text(
                        text = web,
                        modifier = modifier
                            .padding(bottom = 8.dp)
                            .clickable {
                                uriHandler.openUri(web)
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            "Full Name",
            "Title",
            "+123-456-7890",
            "tinghui.duan@gmail.com",
            "https://github.com/t-duan"
        )
    }
}