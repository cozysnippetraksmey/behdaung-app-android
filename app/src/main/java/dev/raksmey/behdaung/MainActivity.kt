package dev.raksmey.behdaung

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import dev.raksmey.behdaung.ui.products.ProductScreen // Import your screen
import dev.raksmey.behdaung.ui.theme.BehdaungTheme

@AndroidEntryPoint // REQUIRED: This is the "Door" for Hilt to enter your Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BehdaungTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Use a Box to respect the system bars (Status bar/Navigation bar)
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ProductScreen() // This replaces Greeting!
                    }
                }
            }
        }
    }
}