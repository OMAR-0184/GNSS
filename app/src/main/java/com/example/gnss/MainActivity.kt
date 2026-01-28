package com.example.gnss

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gnss.ui.GnssScreen
import com.example.gnss.ui.theme.GNSSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                setContent {
                    GNSSTheme {
                        GnssScreen()
                    }
                }
            }
        }
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}