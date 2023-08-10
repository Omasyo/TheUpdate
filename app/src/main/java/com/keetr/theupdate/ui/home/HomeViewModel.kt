package com.keetr.theupdate.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.keetr.theupdate.data.Article
import com.keetr.theupdate.data.HeadlinePagingSource
import com.keetr.theupdate.network.NewsCatcherDatasource
import com.keetr.theupdate.network.createClient
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

const val pageSize = 100

class HomeViewModel : ViewModel() {
    val headlines = Pager(
        config = PagingConfig(
            pageSize = pageSize
        )
    ) {
        HeadlinePagingSource(NewsCatcherDatasource(createClient(CIO.create())), pageSize)
    }.flow.cachedIn(viewModelScope)

    private val _selectedArticle = MutableStateFlow<SelectedArticleState>(SelectedArticleState.None)
    val selectedArticle: StateFlow<SelectedArticleState> = _selectedArticle

    fun selectArticle(article: Article) {
        _selectedArticle.value = SelectedArticleState.Selected(article)
    }

    fun clear() {
        _selectedArticle.value = SelectedArticleState.None
    }
}

sealed interface SelectedArticleState {
    data object None: SelectedArticleState

    class Selected(val article: Article): SelectedArticleState
}