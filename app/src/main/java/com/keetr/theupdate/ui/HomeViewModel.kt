package com.keetr.theupdate.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.keetr.theupdate.data.HeadlinePagingSource
import com.keetr.theupdate.network.DefaultNewsDatasource
import com.keetr.theupdate.network.createClient
import io.ktor.client.engine.cio.CIO

const val pageSize = 20

class HomeViewModel : ViewModel() {
    val headlines = Pager(
        config = PagingConfig(
            pageSize = pageSize
        )
    ) {
        HeadlinePagingSource(DefaultNewsDatasource(createClient(CIO.create())))
    }.flow.cachedIn(viewModelScope)
}