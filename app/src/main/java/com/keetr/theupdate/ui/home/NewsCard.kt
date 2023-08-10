package com.keetr.theupdate.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keetr.theupdate.ui.theme.TheUpdateTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    sourceName: String,
    sourceIconUrl: String,
    publishDate: String,
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

            AsyncImage(
                contentDescription = null,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(sourceIconUrl)
                    .crossfade(true)
                    .build(),
                placeholder = ColorPainter(MaterialTheme.colorScheme.surfaceVariant),
                error = ColorPainter(MaterialTheme.colorScheme.surfaceVariant),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32f.dp)
            )
            Text(sourceName, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.weight(1f))
            Text(
                publishDate,
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
            AsyncImage(
                contentDescription = null,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = ColorPainter(MaterialTheme.colorScheme.surfaceVariant),
                error = ColorPainter(MaterialTheme.colorScheme.surfaceVariant),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .width(120f.dp)
                    .fillMaxHeight()
                    .clip(MaterialTheme.shapes.large)
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
                sourceIconUrl = "",
                publishDate = "30 mins ago",
            ) {}
        }
    }
}