package com.biling.huaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            bottomBar = { HuaMingBottomNavigation() }
        ) {
            padding -> HomeScreen(Modifier.padding(padding))
        }
    }

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

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HuamingTheme {
        HuaMingApp()
    }
}