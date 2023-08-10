package com.keetr.theupdate.data.favicon

object GoogleFavIconGenerator: FavIconGenerator {
    override fun generateUrl(domain: String): String = "http://www.google.com/s2/favicons?domain=$domain"
}