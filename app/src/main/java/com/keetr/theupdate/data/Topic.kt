package com.keetr.theupdate.data

enum class Topic(val param: String) {
    None(""),
    News("news"),
    Sport("sport"),
    Tech("tech"),
    World("world"),
    Finance("finance"),
    Politics("politics"),
    Business("business"),
    Economics("economics"),
    Entertainment("entertainment"),
    Beauty("beauty"),
    Travel("travel"),
    Music("music"),
    Food("food"),
    Science("science"),
    Gaming("gaming"),
    Energy("energy");

    companion object {
        fun from(param: String) = when {
            param.isBlank() -> None
            else -> Topic.valueOf(param.replaceFirstChar { it.uppercaseChar() }) }
    }
}