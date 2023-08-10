package com.keetr.theupdate.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.keetr.theupdate.ui.home.HomeScreen
import com.keetr.theupdate.ui.home.HomeViewModel
import com.keetr.theupdate.ui.home.SelectedArticleState

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TheUpdateApp(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel= viewModel()
) {
    AnimatedContent(
        modifier = modifier,
        targetState = viewModel.selectedArticle.collectAsState().value,
        label = "home_navigator"
    ) { selectedArticle ->
        when (selectedArticle) {
            SelectedArticleState.None -> HomeScreen(
                onNewsCardTap = { article -> viewModel.selectArticle(article) },
                pagingItems = viewModel.headlines.collectAsLazyPagingItems()
            )

            is SelectedArticleState.Selected -> {
                TestScreen {

                }
            }
        }

        BackHandler(selectedArticle is SelectedArticleState.Selected) {
            viewModel.clear()
        }
    }
}