package com.biling.huaming

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biling.huaming.ui.theme.HuamingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HuaMingApp()
        }
    }
}

@Composable
fun HuaMingApp() {
    val navController = rememberNavController()

    HuamingTheme {
        Scaffold(
            topBar = { MingTopBar() },
            bottomBar = { MingBottomNavigation(navController) }
        ) {
            padding ->
            NavHost(
                navController = navController, startDestination = "home",
                Modifier.padding(padding) )
            {
                composable("home") { HomeScreen()}
                composable("profile") { ProfileScreen()}
            }
        }
    }

}

@Composable
fun MingTopBar() {
    TopAppBar(
        title = {
            Text(text = "HuaMing") },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = androidx.compose.ui.graphics.Color.White,
        elevation = 10.dp
    )
}

@Composable
fun MingBottomNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    BottomNavigation(modifier) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {
                navController.navigate("home") {
                    popUpTo("home")
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = true,
            onClick = { navController.navigate("profile") {
                popUpTo("profile")
            }
            }
        )
    }
}



@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column() {
        NewsCard(
            modifier
                .fillMaxWidth()
                .padding(10.dp))
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // User's image
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape),
            painter = painterResource(id = R.drawable.fc2_nature_meditations),
            contentDescription = "Your Image"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // User's name
                Text(
                    text = "Victoria Steele",
                    style = TextStyle(
                        fontSize = 22.sp,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                // User's email
                Text(
                    text = "email123@email.com",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray,
                        letterSpacing = (0.8).sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Edit button
            IconButton(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit Details",
                    tint = MaterialTheme.colors.primary
                )
            }

        }
    }

}

@Composable
fun NewsCard( modifier: Modifier = Modifier ) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.fc2_nature_meditations),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(R.string.fc2_nature_meditations)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    NewsCard()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HuamingTheme {
        HuaMingApp()
    }
}

