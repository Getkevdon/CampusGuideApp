package com.example.campusguideapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.campusguideapp.ui.theme.CampusGuideAppTheme
import com.example.campusguideapp.demos.MobileAppDemos

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusGuideAppTheme(){
                Surface {
                    MobileAppDemos()
                }
            }
        }
    }
}