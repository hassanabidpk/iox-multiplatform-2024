package dev.hassan.ioxplatform

import App
import SportsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Add this line
        FirebaseApp.initializeApp(this)
        setContent {
            SportsScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    SportsScreen()
}