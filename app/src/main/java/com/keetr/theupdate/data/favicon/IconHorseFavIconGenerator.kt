package com.keetr.theupdate.data.favicon

object IconHorseFavIconGenerator: FavIconGenerator {

    override fun generateUrl(domain: String): String = "https://icon.horse/icon/$domain"
}