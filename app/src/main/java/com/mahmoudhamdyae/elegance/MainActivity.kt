package com.mahmoudhamdyae.elegance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mahmoudhamdyae.elegance.home.presentation.screens.HomeScreen
import com.mahmoudhamdyae.elegance.ui.theme.Color1
import com.mahmoudhamdyae.elegance.ui.theme.EleganceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EleganceTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color1)
                ) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}