package com.example.assignment3q4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.assignment3q4.ui.theme.Assignment3Q4Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3Q4Theme {
                Screen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        snackbarHost =  { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {Text("App", fontSize = 20.sp)}
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = {selectedIndex = 0},
                    label = { Text("Home")},
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = {selectedIndex = 1},
                    label = { Text("Settings")},
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedIndex == 2,
                    onClick = {selectedIndex = 2},
                    label = { Text("Profile")},
                    icon = {}
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("FAB clicked")
                }
            }) {
                Text("FAB")
            }
        }
    ) { innerPadding ->
        Text(
            text = "Hello",
            modifier = Modifier.padding(innerPadding),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment3Q4Theme {

    }
}