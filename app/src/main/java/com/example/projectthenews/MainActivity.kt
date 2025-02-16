package com.example.projectthenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectthenews.ui.theme.ProjectTheNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheNewsTheme {
                MyTopAppBar()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {

    val customFont = FontFamily(Font(resId = R.font.bungee_shape))

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title =
                {
                    Text("THE NEWS",
                        style = TextStyle(
                            fontFamily = customFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 10.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Person , contentDescription = "icon bell")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                        }
                    }
                }
            )
        }
    ) {
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheNewsTheme {
        MyTopAppBar()
    }
}