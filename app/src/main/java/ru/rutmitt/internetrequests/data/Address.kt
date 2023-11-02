package ru.rutmitt.internetrequests.data

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipcode: String? = null,
    val geo: Geo = Geo()
)
