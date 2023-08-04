package com.keetr.theupdate.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.keetr.theupdate.R
import com.keetr.theupdate.data.Article

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    onNewsCardTap: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {

    HomeScreen(
        onNewsCardTap = onNewsCardTap,
        pagingItems = viewModel.headlines.collectAsLazyPagingItems()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNewsCardTap: () -> Unit,
    pagingItems: LazyPagingItems<Article>
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
//        LazyColumn(
//            Modifier.padding(innerPadding),
//            contentPadding = PaddingValues(horizontal = 16f.dp, vertical = 16f.dp),
//            verticalArrangement = Arrangement.spacedBy(24f.dp)
//        ) {
//
//            items(20) {
//                NewsCard(
//                    Modifier.height(184f.dp),
//                    title = "International Women's Day: Bisola celebrates mother, daughter",
//                    imageUrl = "",
//                    sourceName = "Source Name",
//                    timestamp = "30 mins ago",
//                    onTap = onNewsCardTap
//                )
//            }
//        }

        when (pagingItems.loadState.refresh) {
            is LoadState.Error -> {

            }
            LoadState.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        Modifier
                            .size(200f.dp, 200f.dp)
                            .align(Alignment.Center))
                }
            }

            is LoadState.NotLoading -> {

                LazyColumn(
                    Modifier.padding(innerPadding),
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
                                publishDate = publishedDate,
                                onTap = onNewsCardTap
                            )
                        }
                    }
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