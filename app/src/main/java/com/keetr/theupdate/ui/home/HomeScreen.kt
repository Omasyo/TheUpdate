package com.keetr.theupdate.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.keetr.theupdate.R
import com.keetr.theupdate.data.Article
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNewsCardTap: (Article) -> Unit,
    pagingItems: LazyPagingItems<Article>
) {
    var errorMessage by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier,
        topBar = {
            TopAppBar(title = {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
            })
        },
        floatingActionButton = {
            Spacer(
                Modifier
                    .size(64.dp)
                    .background(Color.Red)
                    .clickable { pagingItems.refresh() })
        },
    ) { innerPadding ->

        Box(
            Modifier.fillMaxSize()
        ) {
            when (val refreshState = pagingItems.loadState.refresh) {
                is LoadState.Error -> {
                    SideEffect {
                        val message = when (refreshState.error.message) {
                            "LimitReached" -> {
                                "Too many requests sent. Please try again tomorrow"
                            }

                            else -> {
                                ""
                            }
                        }
                        errorMessage = message
                    }
                }

                LoadState.Loading -> {
                    Box(Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            Modifier
                                .size(200f.dp, 200f.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

                is LoadState.NotLoading -> {

                    LazyColumn(
                        modifier = Modifier.padding(innerPadding),
                        contentPadding = PaddingValues(horizontal = 16f.dp, vertical = 16f.dp),
                        verticalArrangement = Arrangement.spacedBy(24f.dp)
                    ) {

                        items(pagingItems.itemCount) {
                            with(pagingItems[it]!!) {
                                NewsCard(
                                    Modifier.height(184f.dp),
                                    title = title,
                                    imageUrl = mediaUrl,
                                    sourceName = author,
                                    sourceIconUrl = sourceIconUrl,
                                    publishDate = publishedDate,
                                    onTap = { onNewsCardTap(this) }
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = errorMessage.isNotBlank(),
                modifier = Modifier.align(Alignment.BottomCenter),
                enter = slideInVertically { it / 2 },
                exit = slideOutVertically { it / 2 }
            ) {
                Box(
                    Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .fillMaxWidth()
                        .padding(16f.dp)
                ) {
                    Text(errorMessage)
                }
            }
        }

    }
}

//@Preview
//@Composable
//private fun Preview() {
//    TheUpdateTheme {
//        HomeScreen() {}
//    }
//}