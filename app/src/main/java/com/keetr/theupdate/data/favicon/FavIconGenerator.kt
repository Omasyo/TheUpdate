package com.keetr.theupdate.data.favicon

interface FavIconGenerator {
    fun generateUrl(domain: String): String
}