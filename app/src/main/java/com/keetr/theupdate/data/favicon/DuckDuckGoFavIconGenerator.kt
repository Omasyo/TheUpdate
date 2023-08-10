package com.keetr.theupdate.data.favicon

object DuckDuckGoFavIconGenerator: FavIconGenerator {
    override fun generateUrl(domain: String): String = "https://icons.duckduckgo.com/ip2/$domain.ico"
}