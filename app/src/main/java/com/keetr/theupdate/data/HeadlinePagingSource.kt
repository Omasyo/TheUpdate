package com.keetr.theupdate.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.keetr.theupdate.data.mapper.toArticles
import com.keetr.theupdate.network.Error
import com.keetr.theupdate.network.NewsDatasource
import com.keetr.theupdate.network.Success

class HeadlinePagingSource(
    private val datasource: NewsDatasource,
    private val pageSize: Int
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1

        val response = datasource.fetchLatestHeadlines(
            duration = "",
            lang = listOf(),
            notLang = listOf(),
            countries = listOf(),
            notCountries = listOf(),
            topic = "",
            sources = listOf(),
            notSources = listOf(),
            rankedOnly = true,
            pageSize = pageSize,
            page = page
        )

        return when (response) {
            is Error -> {
                return LoadResult.Error(
                    Throwable(response.error.errorCode)
                )
            }
            is Success -> {
                val articles = response.data.articles.toArticles()
                return LoadResult.Page(
                    data = articles,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (articles.isEmpty()) null else page.plus(1),
                )
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}