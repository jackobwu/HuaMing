package com.biling.huaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    HuamingTheme {
        Scaffold(
            topBar = { MingTopBar() },
            bottomBar = { HuaMingBottomNavigation() }
        ) {
            padding -> HomeScreen(Modifier.padding(padding))
        }
    }

}

@Composable
fun MingTopBar() {
    TopAppBar(
        title = {
            Text(text = "HuaMing")
        },
        /*navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },*/
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = androidx.compose.ui.graphics.Color.White,
        elevation = 10.dp
    )
}

@Composable
fun HuaMingBottomNavigation(modifier: Modifier = Modifier) {
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
            onClick = {}
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
            onClick = {}
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        NewsCard(
            modifier
                .fillMaxWidth()
                .padding(10.dp))
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
fun DefaultPreview() {
    HuamingTheme {
        HuaMingApp()
    }
}