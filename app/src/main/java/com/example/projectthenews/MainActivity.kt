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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
                MyBottomApp()
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

@Composable
fun MyBottomApp(modifier: Modifier = Modifier) {

    var selected by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index , bottomNavItem ->
                    NavigationBarItem(
                        selected = index == selected ,
                        onClick = {
                            selected = index
//                            navController.navigate(bottomNavItem.route)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color(0xFF99FFCC)
                       ),
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(bottomNavItem.badges != 0){
                                        Badge{
                                            Text(
                                                text = bottomNavItem.badges.toString()
                                            )
                                        }
                                    }else if(bottomNavItem.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector =
                                        if(index == selected)
                                            bottomNavItem.selectedIcon
                                        else
                                            bottomNavItem.unselectedIcon ,
                                    contentDescription = bottomNavItem.title
                                )
                            }
                        } ,
                        label = {
                            Text(text = bottomNavItem.title)
                        }
                    )
                }
            }
        }

    ) {
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Posts",
        route = "posts",
        selectedIcon = Icons.Filled.Build,
        unselectedIcon = Icons.Outlined.Build,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        hasNews = false,
        badges = 5
    ),
    BottomNavItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        hasNews = true,
        badges = 0
    ),

)

data class BottomNavItem(
    val title:String ,
    val route:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badges: Int
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheNewsTheme {
        MyBottomApp()
    }
}