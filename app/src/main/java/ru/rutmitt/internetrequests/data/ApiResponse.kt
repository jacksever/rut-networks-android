package ru.rutmitt.internetrequests.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
    val address: Address? = Address(),
    val phone: String? = null,
    val website: String? = null,
    val company: Company? = Company()
)
