package com.keetr.theupdate.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keetr.theupdate.R
import com.keetr.theupdate.ui.theme.TheUpdateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNewsCardTap: () -> Unit,
    ) {
    Scaffold(
        modifier,
        topBar = {
            TopAppBar(title = {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
            })
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier.padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16f.dp, vertical = 16f.dp),
            verticalArrangement = Arrangement.spacedBy(24f.dp)
        ) {
            items(20) {
                NewsCard(
                    Modifier.height(184f.dp),
                    title = "International Women's Day: Bisola celebrates mother, daughter",
                    imageUrl = "",
                    sourceName = "Source Name",
                    timestamp = "30 mins ago",
                    onTap = onNewsCardTap
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TheUpdateTheme {
        HomeScreen() {}
    }
}