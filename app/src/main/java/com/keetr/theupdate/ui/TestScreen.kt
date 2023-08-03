package com.keetr.theupdate.ui

import android.graphics.drawable.Icon
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TestScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier,
        bottomBar = {
            BottomAppBar {
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Call, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ExitToApp, contentDescription = null)
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16f.dp, vertical = 24f.dp),
            verticalArrangement = Arrangement.spacedBy(16f.dp)
        ) {
            Text("Topic")
            Text(
                "International Women's Day: Bisola celebrates mother, daughter",
                style = MaterialTheme.typography.headlineLarge
            )
            Row {
                Text("Source name", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.weight(1f))
                Text("4 hrs ago", style = MaterialTheme.typography.labelLarge)
            }
            Spacer(
                modifier
                    .fillMaxWidth()
                    .height(240f.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(Color.Cyan)
            )
            Text(
                "\"A cheering crowd danced to the thumping music at Jeddah World Fest, hosted in the Red Sea city of western Saudi Arabia. Such scenes, unimaginable just two years ago, reflect how the ultra-conservative…\"",
                style = MaterialTheme.typography.bodyLarge
            )
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("See Full Story")
            }
        }
    }

    BackHandler {
        onBackPressed()
    }
}