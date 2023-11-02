package ru.rutmitt.internetrequests.data

import kotlinx.serialization.Serializable

@Serializable
data class Geo (
    val lat : String? = null,
    val lng : String? = null
)
