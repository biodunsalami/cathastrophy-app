package com.biodun.cathastrophy.api.models

data class CattyItem(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)