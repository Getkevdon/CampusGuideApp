package com.example.campusguideapp.demos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campusguideapp.campus.CafeteriaDemo
import com.example.campusguideapp.campus.ComputingLabsDemo
import com.example.campusguideapp.campus.LibraryDemo
import com.example.campusguideapp.campus.SportsCentreDemo
import com.example.campusguideapp.campus.StudentSupportDemo

private enum class Demo(val title: String) {
    Library("Library"),
    ComputingLabs("Computing Labs"),
    Cafeteria("Cafeteria"),
    SportsCentre("Sports Centre"),
    StudentSupport("Student Support")
}

@Composable
fun MobileAppDemos() {
    var selectedDemo: Demo? by rememberSaveable { mutableStateOf<Demo?>(null) }

    if (selectedDemo == null) {
        DemoMenu(onSelect = { selectedDemo = it })
    } else {
        DemoScreen(
            demo = selectedDemo!!,
            onBack = { selectedDemo = null }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DemoMenu(onSelect: (Demo) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(
            text = "Campus Guide",
            style = MaterialTheme.typography.headlineMedium) }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("This app was made to help new students explore the campus")
            Demo.entries.forEach { demo ->
                Button(
                    onClick = { onSelect(demo) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(demo.title)
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DemoScreen(demo: Demo, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(demo.title) },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            when (demo) {
                Demo.Library -> LibraryDemo()
                Demo.ComputingLabs -> ComputingLabsDemo()
                Demo.Cafeteria -> CafeteriaDemo()
                Demo.SportsCentre -> SportsCentreDemo()
                Demo.StudentSupport -> StudentSupportDemo()
            }
        }
    }
}
