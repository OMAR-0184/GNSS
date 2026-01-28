package com.example.gnss.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gnss.GnssViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GnssScreen(viewModel: GnssViewModel = viewModel()) {
    val context = LocalContext.current
    val gnssText by viewModel.gnssData.collectAsStateWithLifecycle()

    DisposableEffect(Unit) {
        viewModel.startListening(context)
        onDispose {
            viewModel.stopListening()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("GNSS Measurements") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = gnssText,
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}