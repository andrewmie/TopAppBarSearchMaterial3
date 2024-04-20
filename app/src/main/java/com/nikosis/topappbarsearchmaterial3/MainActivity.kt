package com.nikosis.topappbarsearchmaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nikosis.topappbarsearchmaterial3.ui.appbar.MainViewModel
import com.nikosis.topappbarsearchmaterial3.ui.screens.mainscreen.MainScreen
import com.nikosis.topappbarsearchmaterial3.ui.theme.TopAppBarSearchMaterial3Theme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarSearchMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(mainViewModel = mainViewModel)
                }
            }
        }
    }
}