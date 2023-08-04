package com.keetr.theupdate.network

import com.keetr.theupdate.network.models.ErrorApiModel

sealed interface Response<out T>

class Success<T>(val data: T) : Response<T>

class Error(val error: ErrorApiModel) : Response<Nothing>