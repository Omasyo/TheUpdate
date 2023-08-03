package com.keetr.theupdate.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keetr.theupdate.ui.theme.TheUpdateTheme

enum class NewsCardState {
    Expanded, Compact
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    sourceName: String,
    timestamp: String,
    onTap: () -> Unit
) {
    Column(
        modifier.clickable(onClick = onTap),
        verticalArrangement = Arrangement.spacedBy(8f.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8f.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32f.dp)
            )
            Text(sourceName, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.weight(1f))
            Text(
                timestamp,
                modifier = Modifier.padding(end = 4f.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16f.dp)
        ) {
            Text(
                title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(
                modifier
                    .width(120f.dp)
                    .fillMaxHeight()
                    .clip(MaterialTheme.shapes.large)
                    .background(Color.Cyan)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TheUpdateTheme {
        Surface {
            NewsCard(
                Modifier.height(184f.dp),
                title = "International Women's Day: Bisola celebrates mother, daughter",
                imageUrl = "",
                sourceName = "Source Name",
                timestamp = "30 mins ago",
            ) {}
        }
    }
}